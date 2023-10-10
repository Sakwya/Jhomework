package top.sakwya.Jwork.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.sakwya.Jwork.entity.Employee;

public interface employeeMapper extends BaseMapper<Employee> {
    @Select("select * from employee where user_id != #{user_id}")
    Employee[] queryByUser_Id(int user_id);
}
