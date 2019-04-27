package com.app.service.user;


import java.util.List;
import com.app.model.User;

public interface UserService {
    List<User> getAllUser();
    boolean userLogin(String password,String username);
    User insert(User user);
}
