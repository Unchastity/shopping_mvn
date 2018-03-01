package com.sr.shopping.dao.impl;

import com.sr.shopping.dao.UserDao;
import com.sr.shopping.entity.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User findByUserNameAndPwd(String userName, String password) {
        String hql = "from User user where user.userName = ? and user.password = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setString(0, userName);
        query.setString(1, password);
        return (User) query.uniqueResult();
    }
}
