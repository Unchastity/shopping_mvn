package com.sr.shopping.service;

import com.sr.shopping.entity.User;

import java.util.List;

public interface UserService {

    public User checkUser(User user);

    public void addUser(User user);

    public void delUser(Integer uid);

    public void updateUser(User user);

    public User getUserById(Integer uid);

    /**
     * 用户名/ID/手机号
     * @param object
     * @return
     */
    public List<User> listUsersByParam(Object object);

    public List<User> listUsersByPageAndSize(Integer page, Integer pageSize);

    public Integer totalPageWithSize(Integer pageSize);
}
