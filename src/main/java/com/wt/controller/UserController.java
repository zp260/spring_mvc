package com.wt.controller;

import com.wt.auth.AuthorityHelper;
import com.wt.auth.AuthorityType;
import com.wt.auth.FireAuthority;
import com.wt.controller.util.CallbackMap;
import com.wt.controller.util.UserPowerMap;
import com.wt.model.User;
import com.wt.services.UserService;
import com.wt.tools.MD5Util;
import com.wt.tools.RegexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mrz on 16/7/1.
 */
@Controller
public class UserController extends BaseController {
    @Autowired
    UserService userService;


    @RequestMapping(value = {"/user/reg","user/add"})
    public ModelAndView regUser(@ModelAttribute User user){

        //预置角色列表
        Map<Integer,Object> powerName = new UserPowerMap().getPowerMap();
        //权限列表
        Map<Integer,String> powerList = new UserPowerMap().getPowerListMap();//        获取枚举权限枚举，写入权限列表

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

//    @FireAuthority(authorityTypes = AuthorityType.USER_INSTERT)
    @RequestMapping("/user/insert")
    public String inserData(@ModelAttribute User user){
        if (user !=null && user.getLoginName()!=null && user.getPassWord()!=null && user.getUserName()!=null){
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
    public ModelAndView useredit(@RequestParam int id,@ModelAttribute("userInfo") User user,@ModelAttribute("userPass") User userPass){

        user = userService.getUserById(id);
        String keys= AuthorityHelper.getAuthority(user.getRightContent());
        //预置角色列表
        Map<Integer,Object> powerName = new UserPowerMap().getPowerMap();
        //权限列表
        Map<Integer,String> powerList = new UserPowerMap().getPowerListMap();//        获取枚举权限枚举，写入权限列表

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("user",user);
        map.put("powerName",powerName);
        map.put("powerKeys",keys);
        map.put("powerList",powerList);
        return  new ModelAndView("/user/edit","map",map);
    }

    @ResponseBody
    @RequestMapping("/user/updateInfo")
    public ModelAndView updateUser(@ModelAttribute("userInfo") User user){
        Map<String,Object> callback = new CallbackMap().getCallBackMap();
        String username = user.getUserName();
        if(RegexUtils.checkChinese(username) && user.getUserPower()!="" && user.getRightContent()!=""){
            user.setRightContent(AuthorityHelper.makeAuthority(user.getRightContent()));
            userService.updateInfo(user);
            callback.put("success",true);
            callback.put("info","用户资料修改成功");
            return new ModelAndView(new MappingJackson2JsonView(),callback);
        }else {
            callback.put("success",false);
            callback.put("info","用户资料修改失败");
            return new ModelAndView(new MappingJackson2JsonView(),callback);
        }
    }

    @RequestMapping("/user/updatePass")
    public String updatePass(@ModelAttribute("userPass") User user){
        userService.updatePass(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/user/delete")
    public  String userDelete(@RequestParam int id){
        userService.deleteData(id);
        return "redirect:/user/list";
    }
}
