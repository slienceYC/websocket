package com.app.service.user;

import com.app.model.UserShow;

import java.util.List;

public interface UserShowService {

    void insert(UserShow userShow);

    List<UserShow> selectAll();
}
