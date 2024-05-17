package org.example.listdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.listdemo.dto.UserDTO;
import org.example.listdemo.entity.User;
import org.example.listdemo.mapper.UserMapper;
import org.example.listdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: UserServiceImpl
 * @Description: UserService接口的实现类，继承了MyBatis-Plus提供的ServiceImpl类
 * @author: LiDa
 * @createTime: 2024/5/13 10:01
 * @version: 1.0
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @Authod LiDa
     * @Date 2024/5/14 10:05
     * @Method getUserList
     * @Description 获取User列表
     * @Param
     * @Return
     */
    @Override
    public List<UserDTO> getUserList(Integer currentPage, Integer pageSize) {
        Page<User> page = new Page<>(currentPage, pageSize);
        List<User> userList = userMapper.selectPage(page, null).getRecords();
        if (userList == null) {
            return null;
        }
        // 使用Stream API进行列表转换，提高代码的可读性和简洁性
        return userList.stream()
                .map(this::convertUserToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getUserByCondition(Character gender, String username, Integer currentPage, Integer pageSize) {
        Page<User> page = new Page<>(currentPage, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (gender != null) {
            queryWrapper.eq("gender", gender);
        }
        queryWrapper.like("username", username);
        List<User> userList = userMapper.selectPage(page, queryWrapper).getRecords();
        if (userList != null) {
            return userList.stream()
                    .map(this::convertUserToUserDTO)
                    .collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 将User对象转换为UserDTO对象的辅助方法。
     * 这样做可以提高代码的可维护性和清晰度。
     *
     * @param user 需要转换的User对象
     * @return 转换后的UserDTO对象
     */
    private UserDTO convertUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setGender(user.getGender());
        return userDTO;
    }
}
