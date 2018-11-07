package com.dhht.service.user.impl;

import com.dhht.jpa.UserRepository;
import com.dhht.model.User;
import com.dhht.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        System.out.println("------执行方法-----");
        return  userRepository.findAll();
    }

    @Override
    public  boolean userLogin(String password,String username) {
        System.out.println("------执行方法-----");
        User user =  userRepository.isLogin(password,username);
        if(user==null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public User insert(User user) {
      User u =  userRepository.save(user);
      System.out.println(u.toString());
      return u;
    }
}
