package top.sakwya.Jwork.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.sakwya.Jwork.entity.User;

public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where id = #{id}")
    User getEmployeeByUserId(Long id);

    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);
}
