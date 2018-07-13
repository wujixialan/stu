package com.stu.controller;

import com.stu.entity.Info;
import com.stu.entity.User;
import com.stu.services.InfoService;
import com.stu.util.AuthorityManager;
import com.stu.util.PagMap;
import com.stu.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/info")
public class InfoController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private InfoService infoService;
    private static String nativePath;
    private static String serverPath;

    @GetMapping(value = "/to/{flag}/{infoId}")
    public String to(@PathVariable String flag, @PathVariable(required = false) String infoId, Model model) {
        boolean isUser = AuthorityManager.isUser(request);
        if (isUser) {
            if (flag.equals("info")) {
                return "info/info";
            } else if (flag.equals("infoAdd")) {
                return "info/infoAdd";
            } else if (flag.equals("detail")) {
                Info info = infoService.findByInfoId(infoId);
                model.addAttribute("info", info);
                return "info/infoDetail";
            } else if (flag.equals("edit")) {
                Info info = infoService.findByInfoId(infoId);
                model.addAttribute("info", info);
                return "info/infoEdit";
            }
        } else {
            return "/user/login";
        }
        return null;
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public Map<Object, Object> add(Info info) {
        Map<Object, Object> map = new HashMap<>();
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            PagMap.map(map, "code", 400);
            PagMap.map(map, "msg", "用户未登录，请重新登录");
            return map;
        } else {
            String infoId = UUID.randomUUID().toString().replace("-", "");
            info.setInfoId(infoId);
            info.setInfoTime(new Date());
            info.setUser(user);
            infoService.add(info);
            PagMap.map(map, "code", 200);
            return map;
        }
    }

    @PutMapping(value = "/edit")
    @ResponseBody
    public Map<Object, Object> edit(Info info) {
        System.out.println("info = " + info);
        Map<Object, Object> map = new HashMap<>();
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            PagMap.map(map, "code", 400);
            PagMap.map(map, "msg", "用户未登录，请重新登录");
            return map;
        } else {
            infoService.edit(info);
            PagMap.map(map, "code", 200);
            return map;
        }
    }

    @PostMapping(value = "/info")
    @ResponseBody
    public Map<Object, Object> info(Model model, int curr, int limit) {
        Map<Object, Object> map = new HashMap<>();
        List<Info> infos = infoService.findAllInfo(curr, limit);
        PagMap.map(map, "infos", infos);
        return map;
    }

    @PostMapping(value = "/total")
    @ResponseBody
    public Map<Object, Object> total() {
        Map<Object, Object> map = new HashMap<>();
        long total = infoService.getTotal();
        PagMap.map(map, "total", total);
        return map;
    }

    @DeleteMapping(value = "/del/{infoId}")
    @ResponseBody
    public Map<Object, Object> del(@PathVariable String infoId) {
        Map<Object, Object> map = new HashMap<>();
        Info info = new Info();
        info.setInfoId(infoId);
        try {
            infoService.delInfo(info);
            PagMap.map(map, "code", 200);
            return map;
        } catch (Exception e) {
            PagMap.map(map, "code", 400);
            return map;
        }
    }

    @RequestMapping(value = "/uploadImg")
    public String uploadImg(@RequestParam("upload") MultipartFile file,
                            @RequestParam("CKEditorFuncNum") String CKEditorFuncNum,
                            HttpServletResponse response
    ) throws IOException {
        PrintWriter out = response.getWriter();
        String oriName = file.getOriginalFilename();
        nativePath = request.getServletContext().getRealPath("/") + "image/";
        String fileName = UUIDUtils.uuid();
        String expandedName = oriName.substring(oriName.lastIndexOf("."));
        String flag = validateImage(expandedName);
        if (flag != null) {
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" + flag + "','')");
            out.println("</script>");
        } else {
            file.transferTo(new File(nativePath + fileName + expandedName));
            serverPath = request.getContextPath() + "/image/" + fileName + expandedName;
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" + serverPath + "','')");
            out.println("</script>");
        }
        out.close();
        return null;
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String uploadEx(MaxUploadSizeExceededException ex,
                           @RequestParam HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + 0 + ",'上传文件太大了。','')");
        out.println("</script>");
        return null;
    }


    public String validateImage(String expandedName) {
        expandedName = expandedName.trim();
        Pattern pattern = Pattern.compile("^\\.(gif|jpg|jpeg|png|JPG|PNG)$");
        Matcher matcher = pattern.matcher(expandedName);
        if (!matcher.find()) {
            return "只能上传 jpg,jpeg,png,gif 格式图片";
        }
        return null;
    }
}
