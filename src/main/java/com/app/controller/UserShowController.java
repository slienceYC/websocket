package com.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.app.model.JsonObjectBO;
import com.app.model.UserShow;
import com.app.service.user.UserShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userShow")
public class UserShowController {

    @Autowired
    private UserShowService userShowService;


    @RequestMapping("/show")
    public JsonObjectBO insert(@RequestBody UserShow userShow){
        try {
            userShowService.insert(userShow);
            return JsonObjectBO.ok("分享成功");
        }catch (Exception e){
            return JsonObjectBO.exception("分享失败");
        }
    }

    @RequestMapping("/info")
    public JsonObjectBO info(){
        try {
            JSONObject jsonObject = new JSONObject();
            List<UserShow> userShowList = userShowService.selectAll();
            jsonObject.put("userShows",userShowList);
            return JsonObjectBO.success("获取成功",jsonObject);
        }catch (Exception e){
            return JsonObjectBO.exception("发生异常");
        }
    }
}
