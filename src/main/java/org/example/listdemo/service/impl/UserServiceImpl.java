package org.example.listdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.listdemo.entity.User;
import org.example.listdemo.mapper.UserMapper;
import org.example.listdemo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @projectName: UserServiceImpl
 * @Description: UserService接口的实现类，继承了MyBatis-Plus提供的ServiceImpl类
 * @author: LiDa
 * @createTime: 2024/5/13 10:01
 * @version: 1.0
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
