package com.app.service.user.impl;

import com.app.jpa.UserShowRespository;
import com.app.model.UserShow;
import com.app.service.user.UserShowService;
import com.app.timing.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserShowServiceImpl implements UserShowService {

    @Autowired
    private UserShowRespository userShowRespository;

    @Override
    public void insert(UserShow userShow) {
        userShow.setId(UUIDUtil.generate());
        userShowRespository.save(userShow);
    }

    @Override
    public List<UserShow> selectAll() {
        List<UserShow> userShows = userShowRespository.selectAll();
        return userShows;
    }
}
