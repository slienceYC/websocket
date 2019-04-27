package com.app.service.user.impl;

import com.app.jpa.UserCollectionRespository;
import com.app.model.UserCollection;
import com.app.service.user.UserCollectionService;
import com.app.timing.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date 2019-4-20
 * 用户收藏实现
 */

@Service
public class UserCollectionServiceImpl implements UserCollectionService {

    @Autowired
    private UserCollectionRespository userCollectionRespository;

    @Override
    public int insert(UserCollection userCollection) {
        List<UserCollection> userCollections = userCollectionRespository.selectByUserId(userCollection.getUserId());
        for(UserCollection userCollection1:userCollections){
            if(userCollection.getTitle().equals(userCollection1.getTitle())){
                return 2;
            }
        }
        userCollection.setId(UUIDUtil.generate());
        userCollectionRespository.save(userCollection);
        return 1;
    }

    @Override
    public List<UserCollection> selectByUserId(String userId) {
        return userCollectionRespository.selectByUserId(userId);
    }
}
