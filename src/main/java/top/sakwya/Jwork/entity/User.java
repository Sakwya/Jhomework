package top.sakwya.Jwork.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@TableName("user")
public class User implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    public Long id;
    private String account;
    private String username;
    private String password;
    private String email;

    private String salt;

}
