package com.conhj.provider.dao;

import com.conhj.api.po.UserEntity;
import org.hibernate.engine.spi.ManagedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl  implements IUserDao{

    @PersistenceContext(name = "entityManagerFactory")
    EntityManager entityManager;

    @Override
    public boolean addUser(UserEntity user)  {
        entityManager.persist(user);
        return true;
    }

    @Override
    public boolean updateUser(UserEntity user)  {
        UserEntity u=entityManager.find(UserEntity.class,user.getId());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        return true;
    }
    @Override
    public boolean delUser(UserEntity user)  {
        boolean flag=false;
        UserEntity us=entityManager.find(UserEntity.class,user.getId());
        entityManager.remove(us);
        flag=true;
        return flag;
    }

    @Override
    public List<UserEntity> queryAll() {
        return entityManager.createQuery("From UserEntity u order by u.id desc",UserEntity.class).getResultList();
    }

    @Override
    public UserEntity queryOne(UserEntity userFromWeb) {
        return entityManager.find(UserEntity.class,userFromWeb.getId());
    }
}
