package org.example.listdemo.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: MybatisPlus配置
 * @projectName: ListDemo
 * @packageName: org.example.listdemo.config
 * @author: LiDa
 * @createTime: 2024/5/14 16:46
 * @version: 1.0
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 创建并返回一个分页拦截器
     * @return
     */
    @Bean
    public MybatisPlusInterceptor createPaginationInterceptor() {
        return new MybatisPlusInterceptor();
    }
}