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
    public Employee getEmployee(@PathVariable int id) {
        System.out.print(employeeService.queryByUser_Id(1));
        return employeeService.queryByUser_Id(id);
    }

    @GetMapping("/get2/{id}")
    public Employee[] getEmployee2(@PathVariable int id) {
        System.out.print(employeeService.queryByUser_Id(2));
        return employeeService.queryByUser_Id2(id);
    }

    @PostMapping("/insert")
    public JsonResult<Integer> insertEmployee(@RequestBody Employee employee) {
        try {
            employeeService.insertEmployee(employee);
        } catch (SQLException e) {
            return new JsonResult<Integer>(e.getErrorCode(), e.getSQLState());
        }
        return new JsonResult<Integer>(0);
    }
}
