package com.sr.shopping.controller;

import com.sr.shopping.entity.AdminUser;
import com.sr.shopping.entity.User;
import com.sr.shopping.service.AdminUserService;
import com.sr.shopping.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Resource
    private AdminUserService adminUserService;

    @Resource
    private UserService userService;

    private Logger logger = Logger.getLogger(LoginController.class);

    public static Map<String, String> yzmMap = new HashMap<>();

    static {
        yzmMap.put("flvb", "logYZM.png");
    }

    @RequestMapping("/shopping/login")
    public String toShoppingLogin(HttpSession session, Map<String, Object> map) {
        map.put("user", new User());
        map.put("yzm", "");
        session.setAttribute("loginType", "shopping");
        return "login";
    }

    @RequestMapping("/admin/login")
    public String toAdminLogin(HttpSession session) {
        session.setAttribute("loginType", "admin");
        return "admin/login";
    }

    @RequestMapping(value = "/getyzm", method = RequestMethod.GET)
    @ResponseBody
    public Object getYZM(HttpSession session) {
        Map<String, String> yzm = new HashMap<>();
        String yzmImg = yzmMap.get("flvb");
        yzm.put("yzmImg", yzmImg);
        session.setAttribute("yzmCode", "flvb");
        return yzm;
    }

    @RequestMapping("/admin/exit")
    @ResponseBody
    public Map<String, String> adminLoginout(HttpSession session) {
        session.setAttribute("loginFlag", 0);
        session.setAttribute("loginType", "admin");
        session.removeAttribute("adminUser");
        Map<String, String> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }

    @RequestMapping("/shopping/exit")
    @ResponseBody
    public Map<String, String> shoppingLoginout(HttpSession session) {
        session.setAttribute("loginFlag", 0);
        session.setAttribute("loginType", "shopping");
        session.removeAttribute("user");
        Map<String, String> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }

    @RequestMapping(value = "/admin/tologin", method = {RequestMethod.POST})
    public String adminLogin(AdminUser adminUser,
                             @RequestParam("yzm") String yzm,
                             HttpSession session) {
        session.setAttribute("loginFlag", 0);
        session.setAttribute("loginType", "admin");

        Object yzmCode = session.getAttribute("yzmCode");
        if (yzmCode == null || !yzm.equalsIgnoreCase((String) yzmCode)) {
            return "redirect:/admin/login";
        }
        AdminUser user = adminUserService.checkAdminUser(adminUser);
        if (user.getUid() != null) {
            session.setAttribute("loginFlag", 1);
            session.setAttribute("adminUser", user);
            logger.info("登录成功： " + user.getUserName());
            return "redirect:/admin/index";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/shopping/tologin", method = {RequestMethod.POST})
    public String shoppingLogin( User user,
                                @RequestParam("yzm") String yzm,
                                HttpSession session,
                                BindingResult bindingResult,
                                Map<String, Object> map) {
        session.setAttribute("loginFlag", 0);
        session.setAttribute("loginType", "admin");

        if (bindingResult.hasErrors()) {
            map.put("user", user);
            map.put("yzm", "");
            return "redirect:/shopping/login";
        }
        Object yzmCode = session.getAttribute("yzmCode");
        if (yzmCode == null || !yzm.equalsIgnoreCase((String) yzmCode)) {
            map.put("user", user);
            map.put("yzm", "验证码输入错误");
            return "redirect:/shopping/login";
        }
        User user1 = userService.checkUser(user);
        if (user.getUid() != null) {
            session.setAttribute("loginFlag", 1);
            session.setAttribute("user", user);
            logger.info("登录成功： " + user.getUserName());
            return "redirect:/admin/index";
        }
        map.put("user", user);
        map.put("yzm", "");
        return "redirect:/shopping/login";
    }


}
