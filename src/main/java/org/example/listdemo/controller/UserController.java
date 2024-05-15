package org.example.listdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.listdemo.common.ResultData;
import org.example.listdemo.dto.UserDTO;
import org.example.listdemo.entity.User;
import org.example.listdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @projectName: UserController
 * @Description: 关于用户实体的控制器类
 * @author: LiDa
 * @createTime: 2024/5/13 10:02
 * @version: 1.0
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * @Authod LiDa
     * @Date 2024/5/14 10:08
     * @Method getUserList
     * @Description 分页查询UserList
     * @Param
     * @Return
     */
    @GetMapping("/list")
    public ResultData<List<UserDTO>> getUserList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        try {
            List<UserDTO> userList = userService.getUserList(page, size);
            if (userList == null) {
                return ResultData.failure(ResultData.NOT_FOUND, "查询用户失败：用户列表为空");
            }
            return ResultData.success(ResultData.SUCCESS, "查询用户成功", userList);
        } catch (Exception e) {
            log.error("查询用户失败：未知错误", e);
            return ResultData.failure(ResultData.ERROR, "查询用户失败：未知错误");
        }
    }

    /**
     * @Authod LiDa
     * @Date 2024/5/14 10:08
     * @Method getUserByCondition
     * @Description 条件查询UserList
     * @Param
     * @Return
     */
    @GetMapping("/conditionQuery")
    public ResultData<List<UserDTO>> getUserByCondition(@RequestParam(value = "gender", defaultValue = "") Character gender,
                                                        @RequestParam(value = "username", defaultValue = "") String username,
                                                        @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                        @RequestParam(value = "size", defaultValue = "10") Integer size) {
        try {
            List<UserDTO> userList = userService.getUserByCondition(gender, username, page, size);
            if (userList == null) {
                return ResultData.failure(ResultData.NOT_FOUND, "条件查询用户失败：用户列表为空");
            }
            return ResultData.success(ResultData.SUCCESS, "条件查询用户成功", userList);
        } catch (Exception e) {
            log.error("条件查询用户失败：未知错误", e);
            return ResultData.failure(ResultData.ERROR, "条件查询用户失败：未知错误");
        }
    }

    /**
     * @Authod LiDa
     * @Date 2024/5/14 17:50
     * @Method updateUser
     * @Description 修改User信息
     * @Param
     * @Return
     */
    @PutMapping
    public ResultData<Boolean> updateUser(@RequestBody User user) {
        if (user == null) {
            log.info("提供的用户信息为空");
            return ResultData.failure(ResultData.PARAMS_ERROR, "提供的用户信息为空");
        }
        try {
            boolean result = userService.updateById(user);
            if (!result) {
                return ResultData.failure(ResultData.ERROR, "更新用户失败");
            }
            return ResultData.success(ResultData.SUCCESS, "更新用户成功", result);
        } catch (Exception e) {
            log.error("更新用户失败：未知错误", e);
            return ResultData.failure(ResultData.ERROR, "更新用户失败：未知错误");
        }
    }

    /**
     * @Authod LiDa
     * @Date 2024/5/14 13:55
     * @Method getUserTotal
     * @Description 查询用户总数
     * @Param
     * @Return
     */
    @GetMapping("/total")
    public ResultData<Integer> getUserTotal() {
        try {
            Integer total = userService.count();
            if (total == null) {
                return ResultData.failure(ResultData.NOT_FOUND, "查询用户总数失败");
            }
            return ResultData.success(ResultData.SUCCESS, "查询用户成功", total);
        } catch (Exception e) {
            log.error("查询用户失败：未知错误", e);
            return ResultData.failure(ResultData.ERROR, "查询用户失败：未知错误");
        }
    }

    /**
     * @Authod LiDa
     * @Date 2024/5/14 17:52
     * @Method addUser
     * @Description 添加用户信息
     * @Param
     * @Return
     */
    @PostMapping
    public ResultData<Boolean> addUser(@RequestBody User user) {
        if (user == null) {
            log.info("提供的用户信息为空");
            return ResultData.failure(ResultData.PARAMS_ERROR, "提供的用户信息为空");
        }
        try {
            Boolean isSuccess = userService.save(user);
            return ResultData.success(ResultData.SUCCESS, "添加用户成功", isSuccess);
        } catch (Exception e) {
            log.error("添加用户失败：", e.getMessage());
            return ResultData.failure(ResultData.ERROR, "添加用户失败");
        }
    }

    /**
     * @Authod LiDa
     * @Date 2024/5/14 17:53
     * @Method deleteUser
     * @Description 通过ID删除用户
     * @Param
     * @Return
     */
    @DeleteMapping
    public ResultData<Boolean> deleteUser(@RequestParam("id") Long id) {
        if (id == null) {
            log.info("提供的用户id为空");
            return ResultData.failure(ResultData.PARAMS_ERROR, "提供的用户id为空");
        }
        try {
            Boolean isSuccess = userService.removeById(id);
            return ResultData.success(ResultData.SUCCESS, "删除用户成功", isSuccess);
        } catch (Exception e) {
            log.error("删除用户失败：", e.getMessage());
            return ResultData.failure(ResultData.ERROR, "删除用户失败");
        }
    }
}
