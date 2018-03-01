package com.sr.shopping.controller;

import com.sr.shopping.entity.Response;
import com.sr.shopping.entity.User;
import com.sr.shopping.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/vip")
public class AdminVipController {

    @Resource
    private UserService userService;

    private static final Integer PAGE_SIZE = 5;

    @RequestMapping(value = "/user/page/{page}", method = RequestMethod.GET)
    public String vip(@PathVariable("page") Integer page,
                      Map<String, Object> map) {
        List<User> users = userService.listUsersByPageAndSize(page, PAGE_SIZE);
        Integer pages = userService.totalPageWithSize(PAGE_SIZE);

        map.put("users", users);
        map.put("pages", pages);
        map.put("currentPage", page);
        return "admin/vip";
    }

    @RequestMapping(value = "/user/update/{uid}", method = RequestMethod.GET)
    public String toUpdatePage(@PathVariable("uid") Integer uid,
                               Map<String, Object> map) {

        User user = userService.getUserById(uid);
        map.put("user", user);
        map.put("type", "update");

        return "admin/vipEdit";
    }

    @RequestMapping(value = "/user/toUpdate", method = RequestMethod.POST)
    public String update(User user) {
        User user1 = userService.getUserById(user.getUid());
        user.setPassword(user1.getPassword());
        user.setCode(user1.getCode());
        userService.updateUser(user);
        return "redirect:/vip/user/page/1";
    }

//    @RequestMapping(value = "/user/wallet", method = RequestMethod.POST)
//    public String updateWallet() {
//
//    }

}
