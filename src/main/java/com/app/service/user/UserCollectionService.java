package com.app.service.user;

import com.app.model.UserCollection;

import java.util.List;

/**
 * @author
 * @date 2019-4-20
 */
public interface UserCollectionService {
    /**
     * 添加一个用户收藏
     * @param userCollection
     * @return
     */
    int insert(UserCollection userCollection);

    List<UserCollection> selectByUserId(String userId);


}
