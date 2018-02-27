package com.sr.shopping.dao.impl;

import com.sr.shopping.dao.AdminUserDao;
import com.sr.shopping.entity.AdminUser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Repository("adminUserDao")
@Transactional
public class AdminUserDaoImpl extends BaseDaoImpl<AdminUser> implements AdminUserDao {

    @Override
    public AdminUser findByUserNameAndPwd(String userName, String password) {

        String hql = "from AdminUser user where user.userName = ? and user.password = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setString(0, userName).setString(1, password);
        return (AdminUser) query.uniqueResult();
    }
}
