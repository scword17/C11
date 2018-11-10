package com.conhj.provider.dao;
import com.conhj.api.po.UserEntity;
import java.util.List;
public interface IUserDao {
    public boolean addUser(UserEntity user);
    public boolean updateUser(UserEntity user);
    public boolean delUser(UserEntity user);
    public List<UserEntity> queryAll() ;
    public UserEntity queryOne(UserEntity userFromWeb);
}
