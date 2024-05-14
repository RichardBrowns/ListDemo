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
     * @Description 查询UserList
     * @Param
     * @Return
     */
    @GetMapping("/list")
    public ResultData<List<UserDTO>> getUserList() {
        try {
            List<UserDTO> userList =userService.getUserList();
            if (userList == null){
                return ResultData.failure(ResultData.NOT_FOUND, "查询用户失败：用户列表为空");
            }
            return ResultData.success(ResultData.SUCCESS, "查询用户成功", userList);
        }catch (Exception e){
            log.error("查询用户失败：未知错误",e);
            return ResultData.failure(ResultData.ERROR, "查询用户失败：未知错误");
        }
    }

    /**
     * @Authod LiDa
     * @Date 2024/5/13 12:42
     * @Method getUserById
     * @Description 根据id查询用户信息
     * @Param Long id
     * @Return ResultData<User>
     */
    @GetMapping
    public ResultData<User> getUser(@RequestParam("id") Long id) {
        if (id == null || id <= 0) { // 输入验证
            log.info("提供的用户ID不合法");
            return ResultData.failure(ResultData.PARAMS_ERROR, "提供的用户ID不合法");
        }
        try {
            Object serviceResult = userService.getById(id);
            if (!(serviceResult instanceof User)) { // 类型安全检查
                log.error("查询用户结果类型不匹配");
                return ResultData.failure(ResultData.ERROR, "查询用户失败：结果类型不匹配");
            }
            User user = (User) serviceResult;
            log.info("查询用户成功");
            return ResultData.success(ResultData.SUCCESS, "查询用户成功", user);
        } catch (NullPointerException e) { // 细化异常处理
            log.error("查询用户时发生空指针异常", e.getMessage());
            return ResultData.failure(ResultData.ERROR, "查询用户失败：空指针异常");
        } catch (Exception e) {
            log.error("查询用户失败：", e.getMessage());
            return ResultData.failure(ResultData.ERROR, "查询用户失败");
        }
    }

    @PostMapping
    public ResultData<Boolean> addUser(@RequestBody User user) {
        if (user == null) {
            log.info("提供的用户信息为空");
            return ResultData.failure(ResultData.PARAMS_ERROR, "提供的用户信息为空");
        }
        try {
            Boolean isSuccess = userService.save(user);
            log.info("添加用户成功");
            return ResultData.success(ResultData.SUCCESS, "添加用户成功", isSuccess);
        } catch (Exception e) {
            log.error("添加用户失败：", e.getMessage());
            return ResultData.failure(ResultData.ERROR, "添加用户失败");
        }
    }
}
