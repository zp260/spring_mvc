package com.wt.controller;

import com.wt.model.Port;
import com.wt.services.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mrz on 16/7/8.
 */
@Controller
public class PortController {
    @Autowired
    PortService portService;

    @RequestMapping("/port/list")
    public ModelAndView portList(){
        List<Port>  ports= portService.getPortList();
        return new ModelAndView("/port/list","ports",ports);
    }

    @RequestMapping("/port/add")
    public ModelAndView portAdd(@ModelAttribute Port port){
        return new ModelAndView("/port/add");
    }

    @RequestMapping("/port/insert")
    public String portInsert(@ModelAttribute Port port){
        if (port!= null){
            portService.insertPort(port);
        }

        return "redirect:/port/list";
    }

    @RequestMapping("/port/delete")
    public String portDelete(@RequestParam int id){
        portService.delPort(id);
        return "redirect:/port/list";
    }

    @RequestMapping("/port/update")
    public String portUpdate(@ModelAttribute Port port){
        portService.updatePort(port);
        return "redirect:/port/list";
    }

    @RequestMapping("/port/edit")
    public ModelAndView editPortEdit(@RequestParam int id, @ModelAttribute Port port){
        port = portService.getPortById(id);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("port",port);
        return new  ModelAndView("/port/edit","map",map);
    }
}
