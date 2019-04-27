package com.app.jpa;

import com.app.model.UserShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserShowRespository extends JpaRepository<UserShow,String> {

    @Query("select us from UserShow as us order by us.createTime")
    @Transactional
    List<UserShow> selectAll();
}
