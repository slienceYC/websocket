package com.dhht.jpa;

import com.dhht.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select  u from User u where u.password = ?1 and u.username = ?2")
    @Transactional
    User isLogin(String password,String username);

}
