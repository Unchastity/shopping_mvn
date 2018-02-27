package com.sr.shopping.dao;

import com.sr.shopping.entity.AdminUser;

public interface AdminUserDao extends BaseDao<AdminUser> {

    public AdminUser findByUserNameAndPwd(String userName, String password);
}
