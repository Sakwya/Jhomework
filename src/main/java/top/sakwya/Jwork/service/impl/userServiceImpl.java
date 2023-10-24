package top.sakwya.Jwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakwya.Jwork.entity.User;
import top.sakwya.Jwork.mapper.userMapper;

import java.sql.SQLException;
import java.util.List;

@Service
public class userServiceImpl {
    @Autowired
    userMapper userMapper;
    public List<User> queryAll(){
        return userMapper.selectList(null);
    }

    public User queryByUser_Id(int user_id) {
        System.out.println(userMapper.getEmployeeByUserId(user_id));
        return userMapper.getEmployeeByUserId(user_id);
    }
    public User selectById(int user_id) {
        System.out.println(userMapper.selectById(user_id));
        return userMapper.selectById(user_id);
    }
    public int insertUser(User user) throws SQLException {
        return userMapper.insert(user);
    }
    public int deleteUser(int user_id) throws SQLException {
        return userMapper.deleteById(user_id);
    }
}
