package top.sakwya.Jwork.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.sakwya.Jwork.entity.User;

public interface userMapper extends BaseMapper<User> {

    @Select("select * from user where id = #{id}")
    User getEmployeeByUserId(int id);

    @Select("select * from user where username = #{username}")
    User findByUsername(String username);
}
