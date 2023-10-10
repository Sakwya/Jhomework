package top.sakwya.Jwork.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@TableName("employee")
public class Employee implements Serializable {

    @TableId(value = "user_id")
    private Integer user_id;
    private String account;
    private String user_name;
    private String password;
    private String email;
}
