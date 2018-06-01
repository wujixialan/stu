package com.stu.controller;

import com.stu.analysis.MarkAnalysis;
import com.stu.analysis.MarkAnalysisModel;
import com.stu.analysis.MarkResult;
import com.stu.entity.Mark;
import com.stu.entity.Student;
import com.stu.entity.User;
import com.stu.excel.ReadMarkExcel;
import com.stu.services.MarkService;
import com.stu.services.StudentService;
import com.stu.services.ValidateService;
import com.stu.util.AuthorityManager;
import com.stu.util.Layui;
import com.stu.util.PagMap;
import com.stu.util.UUIDUtils;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping(value = "/mark", method = RequestMethod.GET)
public class MarkController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private MarkService markService;
    @Autowired
    private ValidateService validateService;

    @RequestMapping(value = "/to/{flag}/{subjectId}/{sid}")
    public String to(@PathVariable String flag, @PathVariable(required = false) String subjectId,
                     @PathVariable(required = false) String sid, Model model) {
        boolean isUser = AuthorityManager.isUser(request);
        if (isUser) {
            if (flag.equals("markAdd")) {
                List<Student> students = studentService.getAllStudent();
                model.addAttribute("students", students);
                return "mark/markAdd";
            } else if (flag.equals("markInfo")) {
                return "mark/markInfo";
            } else if (flag.equals("markEdit")) {
                Mark mark = markService.findMarkBySubjectId(subjectId, sid);
                model.addAttribute(mark);
                return "mark/markEdit";
            } else if (flag.equals("markDetail")) {
                model.addAttribute("sid", sid);
                return "mark/markDetail";
            } else if (flag.equals("analysis")) {
                model.addAttribute("sid", sid);
                model.addAttribute("subjectId", subjectId);
                return "mark/analysis";
            } else if (flag.equals("importMark")) {
                return "mark/importMark";
            }
        } else {
            return "/user/login";
        }
        return null;
    }

    @PostMapping(value = "/markAdd")
    @ResponseBody
    public Map<Object, Object> markAdd(@Valid Mark mark, BindingResult br) {
        Map<Object, Object> map = new HashMap<>();
        if (br.hasFieldErrors()) {
            map = validateService.validateMark(br);
            return map;
        }
        mark.setMarkId(UUIDUtils.uuid());
        mark.setReviewId(0);
        markService.markAdd(mark);
        map.put("code", 200);
        return map;
    }

    @PutMapping(value = "/markEdit")
    @ResponseBody
    public Map<Object, Object> markEdit(@Valid Mark mark, BindingResult br) {
        Map<Object, Object> map = new HashMap<>();
        if (br.hasFieldErrors()) {
            map = validateService.validateMark(br);
            return map;
        }
        markService.markEdit(mark);
        map.put("code", 200);
        return map;
    }

    @PostMapping(value = "/markInfo")
    @ResponseBody
    public Layui markInfo(Model model, int page, int limit, Mark mark, String sid) {
        Student student = new Student();
        student.setSid(sid);
        mark.setStudent(student);
        User user = (User) request.getSession().getAttribute("user");
        long total = markService.getMarkTotal(user, mark);
        /**
         * 查询班级相关的信息。
         */
        List<Mark> marks = markService.findAllMark(user, page, limit, mark);
        model.addAttribute("marks", marks);
        JSONArray jsonArray = JSONArray.fromObject(marks);
        return Layui.data((int) total, jsonArray);
    }

    @PostMapping(value = "/markDetail/{sid}")
    @ResponseBody
    public Layui markDetail(@PathVariable String sid, Model model) {
        long total = markService.getMarkTotalBySid(sid);
        /**
         * 查询班级相关的信息。
         */
        List<Mark> marks = markService.getMarkBySid(sid);
        model.addAttribute("marks", marks);
        JSONArray jsonArray = JSONArray.fromObject(marks);
        return Layui.data((int) total, jsonArray);
    }

    @GetMapping(value = "/analysis/{sid}")
    @ResponseBody
    public Map<Object, Object> analysis(@PathVariable String sid) {
        Map<Object, Object> map = new HashMap<>();
        Map<String, MarkResult> results = markService.getMarkResult();
        List<Mark> marks = markService.getMarkBySid(sid);
        MarkAnalysis analysis = new MarkAnalysis();
        MarkAnalysisModel model = analysis.analysis(marks);
        PagMap.map(map, "model", model);
        PagMap.map(map, "result", results.get(sid));
        return map;
    }

    @PostMapping(value = "/importMark")
    @ResponseBody
    public Map<Object, Object> importExcel(MultipartFile file) {
        Map<Object, Object> map = new HashMap<>();
        InputStream in = null;
        if (file != null) {
            List<Mark> marks = null;
            try {
//            得到输入流
                in = file.getInputStream();
//            得到文件的原始名
                String fileName = file.getOriginalFilename();
                marks = ReadMarkExcel.readXlsx(in);
            } catch (Exception e) {
                PagMap.map(map, "code", 400);
                PagMap.map(map, "msg", "导入学生成绩失败");
                return map;
            }
            AtomicInteger count = new AtomicInteger();
            marks.stream().forEach(ele -> {
                ele.setMarkId(UUIDUtils.uuid());
                try {
                    markService.markAdd(ele);
                } catch (Exception e) {
                    count.getAndIncrement();
                    e.printStackTrace();
                }
            });
        }
        PagMap.map(map, "code", 200);
        return map;
    }

    @DeleteMapping(value = "/del/{markId}")
    @ResponseBody
    public Map<Object, Object> del(@PathVariable String markId) {
        Map<Object, Object> map = new HashMap<>();
        try {
            /**
             * 删除 Mark 信息。
             */
            Mark mark = new Mark();
            mark.setMarkId(markId);
            markService.delMark(mark);
            PagMap.map(map, "code", 200);
            return map;
        } catch (Exception e) {
            PagMap.map(map, "code", 400);
            return map;
        }
    }

    @PostMapping(value = "/review/{markId}/{sid}")
    @ResponseBody
    public Map<Object, Object> review(@PathVariable String markId, @PathVariable String sid, Mark mark) {
        Map<Object, Object> map = new HashMap<>();
        mark.setMarkId(markId);
        try {
            markService.updateReview(mark);
            PagMap.map(map, "code", 200);
            PagMap.map(map, "reviewId", mark.getReviewId());
            return map;
        } catch (Exception e) {
            PagMap.map(map, "code", 400);
            return map;
        }
    }
}
