package top.sakwya.Jwork.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@TableName("role")
public class role implements Serializable {
    @TableId(value = "role_id")
    private Integer role_id;
    private String role_name;
}
