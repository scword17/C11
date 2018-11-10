package com.conhj.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.conhj.api.po.UserEntity;
import com.conhj.api.service.IUserService;
import com.conhj.provider.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version="1.0.0",interfaceClass=com.conhj.api.service.IUserService.class)
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao dao;


    @Override
    @Transactional(readOnly=true)
    public List<UserEntity> queryAll() {
        return dao.queryAll();
    }

    @Override
    @Transactional()
    public boolean addUser(UserEntity user) {
        return dao.addUser(user);
    }

    @Override
    @Transactional()
    public boolean delUser(UserEntity user) {
        return dao.delUser(user);
    }

    @Override
    @Transactional(readOnly=true)
    public UserEntity queryOne(UserEntity user) {
        return dao.queryOne(user);
    }

    @Override
    @Transactional()
    public boolean updateUser(UserEntity user) {
        return dao.updateUser(user);
    }
}
