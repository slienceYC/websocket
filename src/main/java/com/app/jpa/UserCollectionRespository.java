package com.app.jpa;

import com.app.model.UserCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserCollectionRespository extends JpaRepository<UserCollection, String> {

    /**
     * 查询用户收藏
     * @param userId
     * @return
     */
    @Query("select us from UserCollection as us where us.userId = ?1")
    @Transactional
    List<UserCollection> selectByUserId(String userId);

}
