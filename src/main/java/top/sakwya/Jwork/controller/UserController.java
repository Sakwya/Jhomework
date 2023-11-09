package top.sakwya.Jwork.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import top.sakwya.Jwork.entity.User;
import top.sakwya.Jwork.entity.JsonResult;
import top.sakwya.Jwork.service.userService;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private userService userService;

    @GetMapping("/show")
    public JsonResult<List<User>> show() {
        System.out.println(userService.queryAll());
        return new JsonResult<>(userService.queryAll());
    }

    @GetMapping("/get/{id}")
    public JsonResult<User> getUser(@PathVariable int id) {
        return new JsonResult<>(userService.queryByUser_Id(id));
    }

    @GetMapping("/get2/{id}")
    public JsonResult<User> getUser2(@PathVariable int id) {
        return new JsonResult<>(userService.selectById(id));
    }

    @PostMapping("/insert")
    public JsonResult<Integer> insertUser(@RequestBody User user) {
        try {
            return new JsonResult<>(userService.insertUser(user));
        } catch (SQLException e) {
            return new JsonResult<>(e.getErrorCode(), e.getSQLState());
        }
    }

    @PostMapping("/delete")
    public JsonResult<Integer> deleteEmployee(@RequestBody User user) {
        try {
            return new JsonResult<>(userService.deleteUser(user.id));
        } catch (SQLException e) {
            return new JsonResult<>(e.getErrorCode(), e.getSQLState());
        }
    }
}
