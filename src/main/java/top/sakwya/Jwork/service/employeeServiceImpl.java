package top.sakwya.Jwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakwya.Jwork.domain.employee;
import top.sakwya.Jwork.mapper.employeeMapper;

import java.io.Serializable;
import java.util.List;

@Service
public class employeeServiceImpl {
    @Autowired
    employeeMapper employeeMapper;
    public List<employee> queryAll(){
        return employeeMapper.selectList(null);
    }

    public employee queryByUser_Id(int user_id) {
        return employeeMapper.selectById(user_id);
    }
}
