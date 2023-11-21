package top.sakwya.Jwork.service;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;
import top.sakwya.Jwork.entity.User;
import top.sakwya.Jwork.mapper.userMapper;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import java.sql.SQLException;
import java.util.List;

@Service
public class userService {
    @Autowired
    userMapper userMapper;

    public List<User> queryAll() {
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

    public boolean isExist(String username) {
        User user = userMapper.findByUsername(username);
        return null != user;
    }

    public int register(User user) {
        String username = user.getUsername();
        String account = user.getAccount();
        String email = user.getEmail();
        String password = user.getPassword();

        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        account = HtmlUtils.htmlEscape(account);
        user.setAccount(account);
        email = HtmlUtils.htmlEscape(email);
        user.setEmail(email);
        user.setId(user.getId()+31);
        if (username.isEmpty() || password.isEmpty()) {
            return 0;
        }

//        boolean exist = isExist(username);
//
//        if (exist) {
//            return 2;
//        }

        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodedPassword = new SimpleHash("sha", password, salt, times).toString();

        user.setSalt(salt);
        user.setPassword(encodedPassword);

        userMapper.insert(user);

        return 1;
    }
}
