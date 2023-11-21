package top.sakwya.Jwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import top.sakwya.Jwork.service.userService;
import org.springframework.web.bind.annotation.*;
import top.sakwya.Jwork.entity.JsonResult;
import top.sakwya.Jwork.entity.User;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    userService userService;

    @PostMapping("/register")
    public JsonResult<User> register(@RequestBody User user) {
        userService.register(user);
        return new JsonResult<>("ok");
    }
    @GetMapping("/test")
    public JsonResult<Object> test(){
        User user = userService.queryByUser_Id(3);
        userService.register(user);
        int status = userService.register(user);
        return switch (status) {
            case 0 -> new JsonResult<>("用户名和密码不能为空");
            case 1 -> new JsonResult<>("注册成功");
            case 2 -> new JsonResult<>("用户已存在");
            default -> new JsonResult<>("未知错误");
        };
    }

}
