package com.sr.shopping.controller;

import com.sr.shopping.entity.Response;
import com.sr.shopping.entity.User;
import com.sr.shopping.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource private UserService userService;

    private static final Integer PAGE_SIZE = 5;

    @RequestMapping("/index")
    public String showAdmin(HttpSession session) {
        session.setAttribute("loginType", "admin");
        return "admin/index";
    }

    @RequestMapping("/header")
    public String header() {
        return "admin/inc/head";
    }

    @RequestMapping("/left")
    public String leftAside() {
        return "admin/inc/left";
    }

    @RequestMapping("/main")
    public String main() {
        return "admin/main";
    }


}
