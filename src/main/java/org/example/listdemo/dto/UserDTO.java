package org.example.listdemo.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * @description: User的DTO类
 * @projectName: ListDemo
 * @packageName: org.example.listdemo.dto
 * @author: LiDa
 * @createTime: 2024/5/14 9:42
 * @version: 1.0
 */
@Data
public class UserDTO {
    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthDate;

    private char gender;
}
