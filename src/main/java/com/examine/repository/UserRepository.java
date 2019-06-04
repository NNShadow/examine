package com.examine.repository;

import com.examine.model.User;
import org.apache.ibatis.annotations.*;

public interface UserRepository {

    //插入数据获取主键
//    @Insert("insert into user(username, password)" + "values (#{username}, #{password})")
//    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
//    public void insertGetKey(User user);

    @Select("select * from user where username = #{username}")
    public User isExist(String username);

    //根据id查询
    @Select("select * from user where id = #{id}")
    public User queryUserById(int id);

    //新增用户
    @Insert("insert into user(username, password)" + "values (#{username}, #{password})")
    public int insertUser(User user);

    //更新用户资源
    @Update("update user set password = #{password} where username = #{username}")
    public int updateUser(User user);

    //删除用户资源
    @Delete("delete from user where id = {#id}")
    public User deleteUserById(int id);

}
