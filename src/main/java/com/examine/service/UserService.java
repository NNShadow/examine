package com.examine.service;

import com.examine.model.User;
import com.examine.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public int insertUser(User user){
        return userRepository.insertUser(user);
    }

    public boolean isEmpty(String username){
        if(userRepository.isExist(username) == null)
            return true;
        else
            return false;
    }

    public String testPassword(User user){
        if(userRepository.isExist(user.getUsername()) == null)
            return null;
        else{
            if(user.getPassword().equals( userRepository.isExist(user.getUsername()).getPassword() )){
                return "true";
            }else {
                return "false";
            }
        }
    }

    //根据id查询
    public User queryUserById(int id){
        return userRepository.queryUserById(id);
    }

    //新增用户
    public int saveUser(User user){
        return userRepository.insertUser(user);
    }

    //更新用户资源
    public int updateUser(User user){
        return userRepository.updateUser(user);
    }

    //删除用户资源
    public User deleteUserById(int id){
        return userRepository.deleteUserById(id);
    }

}
