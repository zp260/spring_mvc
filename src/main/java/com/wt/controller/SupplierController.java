package com.wt.controller;

import com.wt.model.Contract;
import com.wt.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrz on 16/9/13.
 */
@Controller

public class SupplierController {
    @Autowired
    ContractService contractService;

    @RequestMapping("/supplier")
    public String supplier(){
        return "/supplier/supplier";
    }

    @RequestMapping(value = "supplier/search",method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("filedName")String filedName,@RequestParam("search_start") String search_start,@RequestParam(value = "search_end",required = false)String search_end){
        List<Contract> conList = new ArrayList<Contract>();
        ModelAndView mv = new ModelAndView();
        if ("conDate".equals(filedName)){
            if (null!=search_start && null!=search_end && search_end.length()>0 && search_start.length()>0 ){
                conList = contractService.getConByDate(search_start,search_end);
            }
        }else {
                conList = contractService.selectAll(filedName,search_start);
        }
        mv.addObject("list",conList);
        mv.setViewName("/supplier/supplier");
        return mv;
    }
}
