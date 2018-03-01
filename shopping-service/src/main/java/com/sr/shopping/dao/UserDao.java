package com.sr.shopping.dao;

import com.sr.shopping.entity.User;

public interface UserDao extends BaseDao<User> {

    public User findByUserNameAndPwd(String userName, String password);
}
