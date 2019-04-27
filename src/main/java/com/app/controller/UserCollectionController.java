package com.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.app.model.JsonObjectBO;
import com.app.model.UserCollection;
import com.app.service.user.UserCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/UserCollection")
public class UserCollectionController {

    @Autowired
    private UserCollectionService userCollectionService;

    @RequestMapping("/insert")
    public JsonObjectBO insert(@RequestBody UserCollection userCollection){
        try {
            int result = userCollectionService.insert(userCollection);
            if(result==1) {
                return JsonObjectBO.ok("收藏成功");
            }else if(result==2){
                return JsonObjectBO.error("已收藏，请勿重复收藏");
            }else {
                return JsonObjectBO.error("发生未知错误");
            }
        }catch (Exception e){
            return JsonObjectBO.exception("收藏失败");
        }
    }

    @RequestMapping("/info")
    public JsonObjectBO info(@RequestBody Map map){
        try {
            String userId = (String)map.get("userId");
            List<UserCollection> collections = userCollectionService.selectByUserId(userId);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("collections",collections);
            return JsonObjectBO.success("获取成功",jsonObject);
        }catch (Exception e){
            return JsonObjectBO.exception("获取失败");
        }
    }
}
