package top.sakwya.Jwork.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@TableName("user_role")
public class UserRole implements Serializable {
    private Integer uid;
    private Integer rid;
}
