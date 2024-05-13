package org.example.listdemo.entity;

import java.time.LocalDate;
import java.util.Date;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @projectName: User
 * @Description: 实体类User 对应数据库的user表
 * @author: LiDa
 * @createTime: 2024/5/13 9:59
 * @version: 1.0
 */

@Data
@TableName("user") //表名映射
public class User {

    @TableId(type = IdType.AUTO)  //自增主键
    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthDate;

    private char gender;

    private Date createdAt;

    private Date updatedAt;
}
