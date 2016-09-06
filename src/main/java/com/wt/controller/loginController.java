package com.wt.controller;

import com.wt.controller.util.SessionHelper;
import com.wt.model.User;
import com.wt.services.UserService;
import com.wt.tools.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by mrz on 16/7/8.
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value = "error",required = false) String error, @RequestParam(value = "loginOut",required = false) String loginOut){
        ModelAndView model = new ModelAndView();

        if (error != null){
            model.addObject("error","未成功登陆，请输入登陆帐号和密码");
        }
        if (loginOut != null){
            model.addObject("msg","您已经退出登陆");
        }
        model.setViewName("login");
        return model;
    }

    @RequestMapping("/logincheck")
    public ModelAndView doLogin(@ModelAttribute("user") User user, HttpSession httpSession){
        ModelAndView model = new ModelAndView();
        if (user.getPassWord().equals("") && user.getLoginName().equals("") ){
            model.setViewName("redirect:/index?error=error");
        }
        else {
            //        判断密码
            if (userService.checkUserPass(user)){

                User logined = userService.getUserByLoginName(user.getLoginName()); //登陆成功 获取账户信息
                if(logined!=null){
                    //        登陆成功写入SEESION
                    httpSession.setAttribute(SessionHelper.UserHandler, logined);
                }
                model.setViewName("redirect:/login2.html");
            }

        }
        return model;
    }

    @RequestMapping("/head")
    public String head(){
        return "/head";
    }

}
