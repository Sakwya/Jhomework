package top.sakwya.Jwork.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
@TableName("ability")
public class Ability implements Serializable {
    @TableId(value = "ability_id",type = IdType.AUTO)
    private Integer ability_id;
    private String ability_name;
}
