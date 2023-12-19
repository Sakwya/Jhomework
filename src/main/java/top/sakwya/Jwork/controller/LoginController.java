package top.sakwya.Jwork.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.HtmlUtils;
import top.sakwya.Jwork.entity.JsonResult;
import top.sakwya.Jwork.service.UserService;
import org.springframework.web.bind.annotation.*;
import top.sakwya.Jwork.entity.User;

import java.sql.SQLException;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public JsonResult<String> register(@RequestBody User user) {
        int status = userService.register(user);
        return switch (status) {
            case 0 -> new JsonResult<>("用户名和密码不能为空");
            case 1 -> new JsonResult<>("注册成功");
            case 2 -> new JsonResult<>("用户已存在");
            default -> new JsonResult<>("未知错误");
        };
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public JsonResult<String> login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        System.out.println(username);
        Subject subject = SecurityUtils.getSubject();
//        subject.getSession().setTimeout(10000);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        try {
            subject.login(usernamePasswordToken);
            return new JsonResult<>(username);
        } catch (AuthenticationException e) {
            String message = "账号密码错误";
            return new JsonResult<>(message);
        }
    }
}
