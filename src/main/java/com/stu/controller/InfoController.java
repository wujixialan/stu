package com.stu.controller;

import com.stu.entity.Info;
import com.stu.entity.User;
import com.stu.services.InfoService;
import com.stu.util.AuthorityManager;
import com.stu.util.PagMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping(value = "/info")
public class InfoController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private InfoService infoService;

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
            map.put("code", 400);
            map.put("msg", "用户未登录，请重新登录");
            return map;
        } else {
            String infoId = UUID.randomUUID().toString().replace("-", "");
            info.setInfoId(infoId);
            info.setInfoTime(new Date());
            info.setUser(user);
            infoService.add(info);
            map.put("code", 200);
            return map;
        }
    }

    @PutMapping(value = "/edit")
    @ResponseBody
    public Map<Object, Object> edit(Info info) {
        Map<Object, Object> map = new HashMap<>();
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            map.put("code", 400);
            map.put("msg", "用户未登录，请重新登录");
            return map;
        } else {
            infoService.edit(info);
            map.put("code", 200);
            return map;
        }
    }

    @PostMapping(value = "/info")
    @ResponseBody
    public Map<Object, Object> info(Model model, int curr, int limit) {
        Map<Object, Object> map = new HashMap<>();
        List<Info> infos = infoService.findAllInfo(curr, limit);
        map.put("infos", infos);
        return map;
    }

    @PostMapping(value = "/total")
    @ResponseBody
    public Map<Object, Object> total() {
        Map<Object, Object> map = new HashMap<>();
        long total = infoService.getTotal();
        map.put("total", total);
        return map;
    }

    @DeleteMapping(value = "/del/{infoId}")
    @ResponseBody
    public Map<Object, Object> del(@PathVariable String infoId) {
        Map<Object, Object> map = new HashMap<>();
        System.out.println(infoId);
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
}
