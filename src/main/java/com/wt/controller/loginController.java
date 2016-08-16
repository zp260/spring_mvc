package com.wt.controller;

import com.wt.controller.util.SessionHelper;
import com.wt.model.User;
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

    @RequestMapping("/index")
    public String index(){
        return "login";
    }

    @RequestMapping("/logincheck")
    public ModelAndView doLogin(@RequestParam(value = "error",required = false) String error, @RequestParam(value = "loginOut",required = false) String loginOut, @ModelAttribute("user") User user, HttpSession httpSession){
        ModelAndView model = new ModelAndView();

        if (error != null){
            model.addObject("error","请输入登陆帐号和密码");
        }
        if (loginOut != null){
            model.addObject("msg","您已经退出登陆");
        }
//        登陆成功写入SEESION
        httpSession.setAttribute(SessionHelper.UserHandler, user);
        model.setViewName("login");
        return model;
    }


}
