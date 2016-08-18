package com.wt.controller;

import com.wt.auth.AuthorityHelper;
import com.wt.auth.AuthorityType;
import com.wt.auth.FireAuthority;
import com.wt.model.User;
import com.wt.services.UserService;
import com.wt.tools.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Created by mrz on 16/7/1.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping(value = {"/user/reg","user/add"})
    public ModelAndView regUser(@ModelAttribute User user){

        //预置角色列表
        Map<Integer,Object> powerName = new HashMap<Integer, Object>();
        //权限列表
        Map<Integer,String> powerList = new HashMap<Integer, String>();
//        获取枚举权限枚举，写入权限列表
        EnumMap enumMap = new EnumMap(AuthorityType.class);
        for (AuthorityType authorityType : AuthorityType.values()){
            System.out.println(authorityType.getName()+authorityType.getIndex());
            powerList.put(authorityType.getIndex(),authorityType.getName());
        }
        powerName.put(1,"查询员");
        powerName.put(2,"录入员");
        powerName.put(3,"审核员");
        powerName.put(4,"管理员");
        powerName.put(5,"总经理");
        powerName.put(6,"会计");




        Map<String,Object> map = new HashMap<String, Object>();
        map.put("powerName",powerName);
        map.put("powerList",powerList);
        return new ModelAndView("/user/reg","map",map);

    }

    @RequestMapping("/user/list")
    public ModelAndView getUserList(){
        List<User> userList = userService.getUserList();
        return  new ModelAndView("/user/list","userlist",userList);
    }

    @FireAuthority(authorityTypes = AuthorityType.USER_INSTERT)
    @RequestMapping("/user/insert")
    public String inserData(@ModelAttribute User user){
        if (user !=null){
            if (userService.checkUserExist(user)){

                user.setRightContent(AuthorityHelper.makeAuthority(user.getRightContent()));
                userService.insertData(user);
                //提示新增账户成功
            }else{
                //提示账户已存在
            }

        }
        return "redirect:/user/list";
    }

    @RequestMapping("/user/edit")
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
        return  new ModelAndView("/user/edit","map",map);
    }

    @RequestMapping("/user/update")
    public String updateUser(@ModelAttribute User user){
       userService.updateData(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/user/delete")
    public  String userDelete(@RequestParam int id){
        System.out.println("id="+id);
        userService.deleteData(id);
        return "redirect:/user/list";
    }
}
