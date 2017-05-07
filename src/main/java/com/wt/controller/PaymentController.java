package com.wt.controller;

import com.wt.dao.DaoBaseImpl;
import com.wt.jdbc.StageRowMapper;
import com.wt.model.Stage;
import com.wt.services.ContractService;
import com.wt.services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrz on 16/9/13.
 * 付汇
 */
@Controller
public class PaymentController {
    @Autowired
    StageService stageService;
    @Autowired
    DaoBaseImpl daoBase;
    @RequestMapping("/payment")
    public ModelAndView index(@RequestParam(value = "filedName",required = false)String filedName,@RequestParam(value = "value",required = false)String value,@RequestParam(value = "startDate",required = false)String startDate,@RequestParam(value = "endDate",required = false)String endDate){
        List<Stage> list = new ArrayList<Stage>();
        ModelAndView mv = new ModelAndView();
        if (null!= filedName &&filedName.equals("useORG")){
            list = daoBase.select("stage","port",value,new StageRowMapper(),list);
        }else {
            if(null!=startDate && null!=endDate && startDate.length()>0 && endDate.length()>0){
                list = daoBase.selectByDate("stage","fhApproveBillTime",startDate,endDate,new StageRowMapper(),list);
            }
        }
        mv.addObject("list",list);
        mv.setViewName("/payment/index");
        return mv;
    }
}
