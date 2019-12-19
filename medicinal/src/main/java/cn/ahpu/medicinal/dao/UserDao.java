package cn.ahpu.medicinal.dao;

import cn.ahpu.medicinal.pojo.User;

public interface UserDao {

    public User findUserByUsername(String username);

    public void upUser(User user);
}
