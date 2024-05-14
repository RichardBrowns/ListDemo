package org.example.listdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.listdemo.dto.UserDTO;
import org.example.listdemo.entity.User;
import org.example.listdemo.mapper.UserMapper;
import org.example.listdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
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

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * @Authod LiDa
     * @Date 2024/5/14 10:05
     * @Method getUserList
     * @Description 获取User列表
     * @Param
     * @Return
     */
    @Override
    public List<UserDTO> getUserList() {
        List<User> userList = this.list();
        if (userList == null) {
            return null;
        }
        // 使用Stream API进行列表转换，提高代码的可读性和简洁性
        return userList.stream()
                .map(user -> convertUserToUserDTO(user))
                .collect(Collectors.toList());
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
//        // 通过反射自动处理属性复制，减少代码重复
//        // 注意：实际应用中应避免暴露敏感字段，这里假设密码字段不被复制
//        Class<?> clazz = user.getClass();
//        for (Field field : clazz.getDeclaredFields()) {
//            field.setAccessible(true);
//            if (!"password".equals(field.getName())) { // 避免复制密码字段
//                try {
//                    Object value = field.get(user);
//                    System.out.println(userDTO);
////                    field.set(userDTO, value);
//                } catch (IllegalAccessException e) {
//                    logger.error("反射属性复制失败",e.getMessage());
//                    e.printStackTrace();
//                }
//            }
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setGender(user.getGender());
        return userDTO;
    }
}
