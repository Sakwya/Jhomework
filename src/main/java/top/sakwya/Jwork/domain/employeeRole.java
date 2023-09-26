package top.sakwya.Jwork.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@TableName("employee_role")
public class employeeRole implements Serializable {
    private Integer employee_id;
    private Integer role_id;
}
