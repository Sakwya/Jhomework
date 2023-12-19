package top.sakwya.Jwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;
import top.sakwya.Jwork.entity.User;
import top.sakwya.Jwork.mapper.UserMapper;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> queryAll() {
        return userMapper.selectList(null);
    }

    public User queryByUser_Id(Long user_id) {
        System.out.println(userMapper.getEmployeeByUserId(user_id));
        return userMapper.getEmployeeByUserId(user_id);
    }

    public User selectById(Long user_id) {
        System.out.println(userMapper.selectById(user_id));
        return userMapper.selectById(user_id);
    }

    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    public int updateUser(User user) throws SQLException {
        return userMapper.updateById(user);
    }

    public int updateUserPassword(User user) throws SQLException {
        // 加密
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String newPassword = new SimpleHash("md5", user.getPassword(), salt, 2).toString();
        user.setPassword(newPassword);
        return 0;
    }

    public int insertUser(User user) throws SQLException {
        return userMapper.insert(user);
    }

    public int deleteUser(int user_id) throws SQLException {
        return userMapper.deleteById(user_id);
    }

    public boolean isExist(String username) {
        User user = userMapper.selectByUsername(username);
        return null != user;
    }

    public int register(User user) {
        String username = user.getUsername();
        String account = user.getAccount();
        String email = user.getEmail();
        String password = user.getPassword();

        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        account = user.getAccount();
        user.setAccount(account);
        email = HtmlUtils.htmlEscape(email);
        user.setEmail(email);

        if (username.equals("") || password.equals("")) {
            return 0;
        }

        boolean exist = isExist(username);

        if (exist) {
            return 2;
        }

        // 默认生成 16 位盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();

        user.setSalt(salt);
        user.setPassword(encodedPassword);

        userMapper.insert(user);

        return 1;
    }
}
