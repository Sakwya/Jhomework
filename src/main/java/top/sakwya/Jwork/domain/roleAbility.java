package top.sakwya.Jwork.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@TableName("role_ability")
public class roleAbility implements Serializable {
    private Integer role_id;
    private Integer ability_id;
}
