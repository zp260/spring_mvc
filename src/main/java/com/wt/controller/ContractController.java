package com.wt.controller;

import com.wt.model.Contract;
import com.wt.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by mrz on 16/7/14.
 */
@Controller
public class ContractController {
    @Autowired
    ContractService contractService;

    @RequestMapping("/conbase/add")
    public String addCon(@ModelAttribute Contract contract){

        return "/conbase/add";
    }

    @RequestMapping("/conbase/insert")
    public String insertCon(@ModelAttribute Contract contract){

        if (contract!=null){
            contractService.insert(contract);
        }
        return "redirect:/conbase/add";
    }

    @RequestMapping("/conbase/list")
    public ModelAndView conList(){
        List<Contract> conList = contractService.ContractList();
        return new ModelAndView("/conbase/list","list",conList);
    }

    @RequestMapping("test")
    public String test(){
        return "/conbase/test";
    }
}
