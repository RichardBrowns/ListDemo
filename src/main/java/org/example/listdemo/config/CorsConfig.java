package org.example.listdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 配置CORS跨域访问
 * @projectName: ListDemo
 * @packageName: org.example.listdemo.config
 * @author: LiDa
 * @createTime: 2024/5/14 10:49
 * @version: 1.0
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // 允许所有来源
                .allowedMethods("*") // 允许所有HTTP方法
                .allowedHeaders("*") // 允许所有头部
                .maxAge(3600); // 缓存预检请求的过期时间
    }
}

