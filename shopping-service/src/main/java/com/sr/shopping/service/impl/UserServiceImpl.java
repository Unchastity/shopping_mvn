package com.sr.shopping.service.impl;

import com.sr.shopping.dao.UserDao;
import com.sr.shopping.entity.User;
import com.sr.shopping.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User checkUser(User user) {
        return userDao.findByUserNameAndPwd(user.getUserName(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public void delUser(Integer uid) {
        userDao.delete(uid);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public User getUserById(Integer uid) {

       return userDao.get(uid);
    }

    /**
     * 用户名/ID/手机号
     *
     * @param object
     * @return
     */
    @Override
    public List<User> listUsersByParam(Object object) {

        String hql = "from User u where u.userName like '%:username%' or u.uid like '%:uid%' or u.phone like '%:phone%'";
        Map<String, Object> map = new HashMap<>();
        map.put("username", object);
        map.put("uid", object);
        map.put("phone", object);

        return userDao.find(hql, map);
    }

    @Override
    public List<User> listUsersByPageAndSize(Integer page, Integer pageSize) {

        return userDao.find("from User", page, pageSize);
    }

    @Override
    public Integer totalPageWithSize(Integer pageSize) {
        Integer count = userDao.count("select count(*) from User");
        int page = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        return page;
    }
}
