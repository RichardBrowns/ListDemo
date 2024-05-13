package org.example.listdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.example.listdemo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @projectName: UserMapper
 * @Description: User实体类对应的mapper类
 * @author: LiDa
 * @createTime: 2024/5/13 10:00
 * @version: 1.0
 */

@Repository
public interface UserMapper extends BaseMapper<User> {

}
