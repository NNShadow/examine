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
}
