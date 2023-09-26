package top.sakwya.Jwork.controller;

import ch.qos.logback.core.model.Model;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sakwya.Jwork.domain.employee;
import top.sakwya.Jwork.service.employeeServiceImpl;

import java.util.List;

@Controller
@RestController
@RequestMapping("/employee")
public class employeeController {
    @Resource
    private employeeServiceImpl employeeService;
    @GetMapping("/index")
    public String index(Model model){
        return "main";
    }
    @GetMapping("/show")
    public List<employee> show(){
        return employeeService.queryAll();
    }
    @GetMapping("/get/{id}")
    public employee getEmployee(@PathVariable int id){
        System.out.print(employeeService.queryByUser_Id(1));
        return employeeService.queryByUser_Id(id);
    }
}
