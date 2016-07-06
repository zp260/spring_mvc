package com.wt.controller;

import com.wt.model.User;
import com.wt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mrz on 16/7/1.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/reg")
    public ModelAndView regUser(@ModelAttribute User user){

        List<String> powerList = new ArrayList<String>();
        powerList.add("录入员");
        powerList.add("查询员");
        powerList.add("审核员");
        powerList.add("管理员");

        Map<String,List> map = new HashMap<String, List>();
        map.put("powerList",powerList);
        return new ModelAndView("reg","map",map);

    }

    @RequestMapping("/userlist")
    public ModelAndView getUserList(){
        List<User> userList = userService.getUserList();
        return  new ModelAndView("userlist","userlist",userList);
    }

    @RequestMapping("/insert")
    public String inserData(@ModelAttribute User user){
        if (user !=null){
            userService.insertData(user);
        }
        return "redirect:/userlist";
    }

    @RequestMapping("useredit")
    public ModelAndView useredit(@RequestParam int id,@ModelAttribute User user){
        user = userService.getUserById(id);
        List<String> powerList = new ArrayList<String>();
        powerList.add("录入员");
        powerList.add("查询员");
        powerList.add("审核员");
        powerList.add("管理员");

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("powerList",powerList);
        map.put("user",user);
        return  new ModelAndView("useredit","map",map);
    }

    @RequestMapping("/update")
    public String updateUser(@ModelAttribute User user){
       userService.updateData(user);
        return "redirect:/userlist";
    }

    @RequestMapping("/userdelete")
    public  String userDelete(@RequestParam int id){
        System.out.println("id="+id);
        userService.deleteData(id);
        return "redirect:/userlist";
    }
}
