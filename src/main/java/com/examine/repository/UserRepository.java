package com.examine.repository;

import com.examine.model.User;
import org.apache.ibatis.annotations.*;

public interface UserRepository {
    @Insert("insert into user(username, password)" + "values (#{username}, #{password})")
    public int insertUser(User user);

    //插入数据获取主键
//    @Insert("insert into user(username, password)" + "values (#{username}, #{password})")
//    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
//    public void insertGetKey(User user);

    @Select("select * from user where username = #{username}")
    public User isExist(String username);

}
