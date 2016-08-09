package com.wt.controller;

import com.wt.model.FullyFunded;
import com.wt.services.FullyFundedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by mrz on 16/8/4.
 */
@Controller
public class FullyFundedController {
    @Autowired
    FullyFundedService fullyFundedService;

    @RequestMapping("/fully/add")
    public String add(@ModelAttribute FullyFunded fullyFunded){
        return "/fully/add";
    }

    @RequestMapping("/fully/insert")
    public String insert(@ModelAttribute FullyFunded fullyFunded){
        if (fullyFunded!=null){
            fullyFundedService.insert(fullyFunded);
        }
        return "/fully/list";
    }

    @RequestMapping("/fully/list")
    public ModelAndView list(){
       List<FullyFunded> list =  fullyFundedService.list();
        return new ModelAndView("/fully/list","list",list);
    }

    @RequestMapping("/fully/edit")
    public ModelAndView eidt(@RequestParam int id){
       FullyFunded fullyFunded =  fullyFundedService.getFullyFundedById(id);

        return new ModelAndView("/fully/edit","list",fullyFunded);

    }

    @RequestMapping("/fully/update")
    public String update(@ModelAttribute FullyFunded fullyFunded){
        if (fullyFunded!=null){
            fullyFundedService.update(fullyFunded);
        }
        return "redirect:/fully/list";
    }
    @RequestMapping("/fully/del")
    public String del(@RequestParam int id){
        if (id>0) fullyFundedService.delete(id);
        return "redirect:/fully/list";

    }
}
