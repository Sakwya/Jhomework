package top.sakwya.Jwork.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@TableName("role_ability")
public class RoleAbility implements Serializable {
    private Integer role_id;
    private Integer ability_id;
}