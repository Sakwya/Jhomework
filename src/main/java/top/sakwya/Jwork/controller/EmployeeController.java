package top.sakwya.Jwork.controller;

import ch.qos.logback.core.model.Model;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.sakwya.Jwork.entity.Employee;
import top.sakwya.Jwork.entity.JsonResult;
import top.sakwya.Jwork.service.impl.employeeServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Resource
    private employeeServiceImpl employeeService;

    @GetMapping("/show")
    public List<Employee> show() {
        return employeeService.queryAll();
    }

    @GetMapping("/get/{id}")
    public JsonResult<Employee> getEmployee(@PathVariable int id) {
        System.out.println(id);
        return new JsonResult<>(employeeService.queryByUser_Id(id));
    }

    @PostMapping("/insert")
    public JsonResult<Integer> insertEmployee(@RequestBody Employee employee) {
        try {
            return new JsonResult<>(employeeService.insertEmployee(employee));
        } catch (SQLException e) {
            return new JsonResult<>(e.getErrorCode(), e.getSQLState());
        }
    }

    @PostMapping("/delete")
    public JsonResult<Integer> deleteEmployee(@RequestBody Employee employee) {
        try {
            return new JsonResult<>(employeeService.deleteEmployee(employee.user_id));
        } catch (SQLException e) {
            return new JsonResult<>(e.getErrorCode(), e.getSQLState());
        }
    }
}
