package org.example.listdemo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.example.listdemo.entity.User;


public interface UserMapper {
    @Insert("INSERT INTO public.users (username, password, first_name, last_name, email, birth_date, gender) "
            + "VALUES (#{username}, #{password}, #{firstName}, #{lastName}, #{email}, #{birthDate}, #{gender})")
    int insertUser(User user);
}
