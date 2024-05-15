package org.example.listdemo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.listdemo.dto.UserDTO;
import org.example.listdemo.entity.User;

import java.util.List;

/**
 * @projectName: UserService
 * @Description: 实现了IService<User>接口的UserService接口
 * @author: LiDa
 * @createTime: 2024/5/13 10:01
 * @version: 1.0
 */

public interface UserService extends IService<User> {
    public List<UserDTO> getUserList(Integer currentPage, Integer pageSize);

    public List<UserDTO> getUserByCondition(Character gender, String username, Integer currentPage, Integer pageSize);
}
