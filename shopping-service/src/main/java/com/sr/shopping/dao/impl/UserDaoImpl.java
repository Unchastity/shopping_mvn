package com.sr.shopping.dao.impl;

import com.sr.shopping.dao.UserDao;
import com.sr.shopping.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
