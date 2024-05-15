package org.example.listdemo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @projectName: ListDemo
 * @packageName: org.example.listdemo.config
 * @author: LiDa
 * @createTime: 2024/5/14 16:46
 * @version: 1.0
 */
@Configuration
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 可以根据需求调整分页插件的配置
        // paginationInterceptor.setDialectType(DialectType.MYSQL);
        return paginationInterceptor;
    }
}