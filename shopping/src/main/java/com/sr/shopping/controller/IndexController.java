package com.sr.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shopping")
public class IndexController {

    @RequestMapping("/index")
    public String showShopping(HttpSession session) {
        session.setAttribute("loginType", "shopping");
        return "index";
    }





}
