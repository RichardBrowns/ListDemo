package org.example.listdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * 配置CORS（Cross-Origin Resource Sharing，跨域资源共享）跨域访问的配置类
 * 主要作用是解决浏览器实施的同源策略限制，
 * 从而允许不同源（协议、域名、端口任意一个不同即视为不同源）的前端应用
 * 能够向后端服务发起Ajax请求。
 * @projectName: ListDemo
 * @packageName: org.example.listdemo.config
 * @author: LiDa
 * @createTime: 2024/5/14 10:49
 * @version: 1.0
 */
//@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 对所有请求都应用CORS
                .allowedOrigins("http://localhost:2024") // 替换为你的实际允许的源
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*") // 可以根据需要调整允许的头部
                .allowCredentials(true); // 保持允许凭证
    }
}

