package org.example.listdemo.config;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.context.annotation.Configuration;


/**
 * @description: MyBatis配置类
 * @projectName: ListDemo
 * @packageName: org.example.listdemo.config
 * @author: LiDa
 * @createTime: 2024/5/13 11:31
 * @version: 1.0
 */
@Configuration
@MapperScan("org.example.listdemo.mapper") // 指定Mapper接口所在的包路径
public class MyBatisConfig {

}
