package cn.ahpu.medicinal.impl;

import cn.ahpu.medicinal.dao.UserDao;
import cn.ahpu.medicinal.mapper.UserMapper;
import cn.ahpu.medicinal.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        User user = userMapper.findUserByUsername(username);
        return user;
    }

    @Override
    public void upUser(User user) {
        userMapper.upUser(user);
    }
}
