package com.stu.controller;

import com.stu.entity.User;
import com.stu.excel.ReadUserExcel;
import com.stu.services.UserService;
import com.stu.services.ValidateService;
import com.stu.util.AuthorityManager;
import com.stu.util.Layui;
import com.stu.util.PagMap;
import com.stu.util.PwdEncryption;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserController {
    @Autowired
    private ValidateService validateService;
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    /**
     * 去到某一个页面。
     *
     * @param flag
     * @return
     */
    @GetMapping(value = "/to/{flag}")
    public String login(@PathVariable String flag) {
        if (flag.equals("login")) {
            return "/user/login";
        } else if (flag.equals("register")) {
            return "/user/register";
        }
        boolean isUser = AuthorityManager.isUser(request);
        if (isUser) {
            if (flag.equals("changePassword")) {
                return "/user/changePassword";
            } else if (flag.equals("authorized")) {
                return "user/authorized";
            }else if (flag.equals("importUser")) {
                return "user/importUser";
            }
        } else {
            return "/user/login";
        }
        return null;
    }

    /**
     * 登录
     *
     * @param user：User 对象
     * @param br：绑定 User 的验证错误信息
     * @return
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public Map<Object, Object> login(@Valid User user, BindingResult br) {
        Map<Object, Object> map = new HashMap<>();
        if (br.hasFieldErrors()) {
            /**
             * 如果有错误，进入 validate() 方法进行验证。
             */
            map = validateService.validateUser(br);
            return map;
        } else {
            user = PwdEncryption.encryption(user);
            boolean flag = userService.getUser(user);
            if (flag) {
                /**
                 *
                 */
                request.getSession().invalidate();
                request.getSession().setAttribute("user", user);
                /**
                 * 否则返回成功的 code。
                 */
                PagMap.map(map, "code", 200);
                return map;
            } else {
                PagMap.map(map, "code", 400);
                PagMap.map(map, "msg", "msg");
                PagMap.map(map, "msgField", "用户不存在");
                return map;
            }
        }
    }

    /**
     * 注册
     *
     * @param user：User 对象
     * @param br：绑定     User 验证错误。
     * @return
     */
    @PostMapping(value = "/register")
    @ResponseBody
    public Map<Object, Object> register(@Valid User user, BindingResult br) {
        Map<Object, Object> map = new HashMap<>();
        if (br.hasFieldErrors()) {
            /**
             * 如果有错误，进入 validate() 方法进行验证。
             */
            map = validateService.validateUser(br);
            return map;
        } else {
            user = PwdEncryption.encryption(user);
            boolean flag = userService.findUserByUserId(user);
            if (flag) {
                userService.save(user);
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

    /**
     * 登出
     *
     * @return
     */
    @GetMapping(value = "/signOut")
    public String signOut() {
        request.getSession().removeAttribute("user");
        return "/user/login";
    }

    /**
     * 修改密码
     *
     * @param newPwd：新密码
     * @return
     */
    @PostMapping(value = "/changePassword")
    @ResponseBody
    public Map<Object, Object> changePassword(String newPwd) {
        Map<Object, Object> map = new HashMap<>();
        User user = (User) request.getSession().getAttribute("user");
        user.setPassword(newPwd);
        user = PwdEncryption.encryption(user);
        userService.changePassword(user);
        PagMap.map(map, "code", 200);
        return map;
    }

    /**
     * 得到旧密码
     *
     * @return
     */
    @PostMapping(value = "/oldPwd/{pwd}")
    @ResponseBody
    public Map<Object, Object> getOldPwd(@PathVariable String pwd) {
        Map<Object, Object> map = new HashMap<>();
        User user = (User) request.getSession().getAttribute("user");
        user.setPassword(pwd);
        user = PwdEncryption.encryption(user);
        boolean flag = userService.getOldPwd(user);
        if (flag) {
            PagMap.map(map, "code",200);
            return map;
        } else {
            PagMap.map(map, "code", 400);
            PagMap.map(map, "msg", "旧密码和原密码不一致");
            return map;
        }
    }

    @PostMapping(value = "/authorized")
    @ResponseBody
    public Layui authorized() {
        boolean flag = AuthorityManager.isUser(request);
        if (flag) {
            User user = (User) request.getSession().getAttribute("user");
            long total = userService.authorizedTotal(user);
            List<User> users = userService.authorized(user);
            JSONArray jsonArray = JSONArray.fromObject(users);
            return Layui.data((int) total, jsonArray);
        }
        return null;
    }

    @PostMapping(value = "/importUser")
    @ResponseBody
    public Map<Object, Object> importExcel(MultipartFile file) {
        Map<Object, Object> map = new HashMap<>();
        InputStream in = null;
        try {
            if (file != null) {
                try {
                    //            得到输入流
                    in = file.getInputStream();
                    //            得到文件的原始名
                    String fileName = file.getOriginalFilename();
                    List<User> users = ReadUserExcel.readXlsx(in);
                    users.stream().forEach(ele -> {
                        userService.save(ele);
                    });
                } catch (Exception e) {
                    PagMap.map(map, "code", 400);
                    PagMap.map(map, "msg", "导入用户登录信息失败");
                    return map;
                }
            }
            PagMap.map(map, "code", 200);
            return map;
        } catch (Exception e) {
            PagMap.map(map, "code", 400);
            return map;
        }
    }
}
