package top.sakwya.Jwork.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@TableName("role_menu")
public class RoleMenu implements Serializable {
    private Integer rid;
    private Integer mid;
}
