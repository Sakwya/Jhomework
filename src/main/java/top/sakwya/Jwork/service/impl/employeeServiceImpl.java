package top.sakwya.Jwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakwya.Jwork.entity.Employee;
import top.sakwya.Jwork.mapper.employeeMapper;

import java.sql.SQLException;
import java.util.List;

@Service
public class employeeServiceImpl {
    @Autowired
    employeeMapper employeeMapper;
    public List<Employee> queryAll(){
        return employeeMapper.selectList(null);
    }

    public Employee queryByUser_Id(int user_id) {
        System.out.println(employeeMapper.getEmployeeByUserId(user_id));
        return employeeMapper.getEmployeeByUserId(user_id);
    }
    public int insertEmployee(Employee employee) throws SQLException {
        return employeeMapper.insert(employee);
    }
    public int deleteEmployee(int user_id) throws SQLException {
        return employeeMapper.deleteById(user_id);
    }
}
