package top.sakwya.Jwork.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
@TableName("ability")
public class ability implements Serializable {
    @TableId(value = "ability_id")
    private Integer ability_id;
    private String ability_name;
}
