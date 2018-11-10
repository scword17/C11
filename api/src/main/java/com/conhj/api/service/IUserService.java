package com.conhj.api.service;

import com.conhj.api.po.UserEntity;

import java.util.List;

public interface IUserService {
    public List<UserEntity> queryAll();
    public boolean addUser(UserEntity user);
    public boolean delUser(UserEntity user);
    public UserEntity queryOne(UserEntity user);
    public boolean updateUser(UserEntity user);
}
