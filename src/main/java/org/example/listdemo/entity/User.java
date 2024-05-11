package org.example.listdemo.entity;

import java.time.LocalDate;
import java.util.Date;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

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
