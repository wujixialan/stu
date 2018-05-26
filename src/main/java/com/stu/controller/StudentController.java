package com.stu.controller;

import com.stu.entity.Clazz;
import com.stu.entity.Mark;
import com.stu.entity.Student;
import com.stu.entity.User;
import com.stu.excel.ReadStudentExcel;
import com.stu.services.ClazzService;
import com.stu.services.MarkService;
import com.stu.services.StudentService;
import com.stu.services.ValidateService;
import com.stu.util.AuthorityManager;
import com.stu.util.Layui;
import com.stu.util.PagMap;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/student", method = RequestMethod.GET)
public class StudentController {
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ValidateService validateService;
    @Autowired
    private MarkService markService;


    @GetMapping(value = "/to/{flag}/{sid}")
    public String to(@PathVariable String flag, @PathVariable(required = false) String sid, Model model) {
        /**
         * 通过判断 Session 中是否存在 User，来进行判断是否展示数据，若不存在，则需要登录。
         */
        boolean isUser = AuthorityManager.isUser(request);
        /**
         * 当存在用户登录时，可以进行数据的展示。
         * 不存在时，跳转到登录页面。让用户登录。
         */
        if (isUser) {
            if (flag.equals("stuInfo")) {
                List<Clazz> clazzes = clazzService.getAllClazz();
                model.addAttribute("clazzes", clazzes);
                return "stu/stuInfo";
            } else if (flag.equals("stuDetail")) {
                Student student = (Student) studentService.findStudent(sid);
                model.addAttribute("student", student);
                return "stu/stuDetail";
            } else if (flag.equals("stuAdd")) {
                List<Clazz> clazzes = clazzService.getAllClazz();
                model.addAttribute("clazzes", clazzes);
                return "stu/stuAdd";
            } else if (flag.equals("stuEdit")) {
                List<Clazz> clazzes = clazzService.getAllClazz();
                Student student = (Student) studentService.findStudent(sid);
                model.addAttribute("student", student);
                model.addAttribute("clazzes", clazzes);
                return "stu/stuEdit";
            } else if (flag.equals("importStu")) {
                return "stu/importStu";
            }
        } else {
            return "/user/login";
        }
        return null;
    }

    @PostMapping(value = "/stuInfo")
    @ResponseBody
    public Layui getAllClazz(Model model, int page, int limit, Student student, String cid) {
        Clazz clazz = new Clazz();
        clazz.setCid(cid);
        student.setClazz(clazz);
        User user = (User) request.getSession().getAttribute("user");
        /**
         * 获取班级的总记录数
         */
        long total = studentService.getStudentTotal(student, user);
        /**
         * 查询班级相关的信息。
         */
        String newStr = "***********";
        List<Student> students = studentService.getAllPageStudent(page, limit, student, user);
        students.stream().forEach(ele -> {
            String str = ele.getIdCard();
            String sub = str.substring(3, 14);
            str = str.replace(sub, newStr);
            ele.setIdCard(str);
        });
        model.addAttribute("students", students);
        JSONArray jsonArray = JSONArray.fromObject(students);
        return Layui.data((int) total, jsonArray);
    }

    /**
     * 添加学生的基本信息
     *
     * @param student：学生基本信息对象
     * @param br：绑定字段，验证结果是否有填写错误。
     * @return
     */
    @PostMapping(value = "/stuAdd")
    @ResponseBody
    public Map<Object, Object> stuAdd(@Valid Student student, BindingResult br) {
        Map<Object, Object> map = new HashMap<>();
        if (br.hasFieldErrors()) {
            /**
             * 如果有错误，进入 validate() 方法进行验证。
             */
            map = validateService.validateStudent(br);
            return map;
        } else {
            student.setReviewContent("学生未审核");
            student.setReviewId(0);
            boolean flag = studentService.isSid(student);
            if (flag) {
                studentService.stuAdd(student);
                PagMap.map(map, "code", 200);
                return map;
            } else {
                PagMap.map(map, "code", 400);
                PagMap.map(map, "msg", "msg");
                PagMap.map(map, "msgField", "该用户已经注册");
                return map;
            }
        }
    }

    @PutMapping(value = "/stuEdit")
    @ResponseBody
    public Map<Object, Object> stuEdit(@Valid Student student, BindingResult br) {
        Map<Object, Object> map = new HashMap<>();
        if (br.hasFieldErrors()) {
            /**
             * 如果有错误，进入 validate() 方法进行验证。
             */
            map = validateService.validateStudent(br);
            return map;
        } else {
            studentService.stuEdit(student);
            map.put("code", 200);
            return map;
        }
    }

    @PostMapping(value = "/importStu")
    @ResponseBody
    public Map<Object, Object> importExcel(MultipartFile file) throws IOException {
        Map<Object, Object> map = new HashMap<>();
        InputStream in = null;
        if (file != null) {
//            得到输入流
            in = file.getInputStream();
//            得到文件的原始名
            String fileName = file.getOriginalFilename();
            List<Student> students = ReadStudentExcel.readXlsx(in);
            students.stream().forEach(ele -> {
                studentService.stuAdd(ele);
            });
        }
        PagMap.map(map, "code", 200);
        return map;
    }

    @DeleteMapping(value = "/del/{sid}")
    @ResponseBody
    public Map<Object, Object> del(@PathVariable String sid) {
        Map<Object, Object> map = new HashMap<>();
        /**
         * 根据 sid 获取 Mark 集合数据
         */
        List<Mark> marks = markService.getMarkBySid(sid);
        try {
            /**
             * 删除 Mark 信息。
             */
            markService.delMarks(marks);
            Student stu = new Student();
            stu.setSid(sid);
            studentService.delStu(stu);
        } catch (Exception e) {
            PagMap.map(map, "code", 400);
            return map;
        }
        PagMap.map(map, "code", 200);
        return map;
    }

    @PostMapping(value = "/review/{sid}")
    @ResponseBody
    public Map<Object, Object> review(@PathVariable String sid, Student student) {
        Map<Object, Object> map = new HashMap<>();
        student.setSid(sid);
        System.out.println(student);
        try {
            studentService.updateReview(student);
            PagMap.map(map, "code", 200);
            PagMap.map(map, "reviewId", student.getReviewId());
            return map;
        } catch (Exception e) {
            PagMap.map(map, "code", 400);
            return map;
        }
    }
}
