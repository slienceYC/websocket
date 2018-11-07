package com.dhht.controller;

import com.alibaba.fastjson.JSONObject;
import com.dhht.model.Result;
import com.dhht.service.user.UserService;
import com.dhht.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public String getUer(){
        JSONObject jsonObject = new JSONObject();
        List<User> list = userService.getAllUser();
        jsonObject.put("user",list);
        return jsonObject.toString();
    }

    @RequestMapping("/login")
    public JSONObject login(@RequestBody Map map){
        String username = (String) map.get("username");
        String password = (String)map.get("password");
        JSONObject jsonObject = new JSONObject();
        boolean result = userService.userLogin(password,username);
        if(result){
           Result success = new Result(1,"success",true);
           jsonObject.put("result",success);
        }else {
            Result fail = new Result(-1,"fail",false);
            jsonObject.put("result",fail);
        }
        return jsonObject;
    }
    
}
