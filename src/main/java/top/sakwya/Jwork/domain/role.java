package top.sakwya.Jwork.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("role")
public class role {
    @TableId(value = "role_id")
    private Integer role_id;
    private String role_name;
}
