//package org.example.listdemo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @description:
// * @projectName: ListDemo
// * @packageName: org.example.listdemo.config
// * @author: LiDa
// * @createTime: 2024/5/17 16:31
// * @version: 1.0
// */
////@Configuration
////@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .anyRequest().authenticated() // 所有请求都需要身份验证
//                .and()
//            .formLogin() // 使用默认的表单登录
//                .permitAll() // 允许所有用户访问登录页面
//                .and()
//            .logout()
//                .permitAll(); // 允许所有用户注销
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication() // 使用内存中的用户信息
//                .withUser("admin").password("{noop}admin").roles("ADMIN");
//    }
//}
