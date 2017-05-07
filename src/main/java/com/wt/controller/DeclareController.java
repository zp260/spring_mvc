package com.wt.controller;

import com.wt.dao.DaoBase;
import com.wt.jdbc.StageRowMapper;
import com.wt.model.Stage;
import com.wt.searchBean.DeclareBean;
import com.wt.services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrz on 16/9/14.
 * 报关
 */
@Controller
public class DeclareController {
    @Autowired
    StageService stageService;
    @RequestMapping(value = "/declare")
    public ModelAndView index(@RequestParam(value = "startDate",required = false)String startDate,@RequestParam(value = "endDate",required = false)String endDate){
        List<DeclareBean> list = new ArrayList<DeclareBean>();
        ModelAndView mv = new ModelAndView();
        if(null!=startDate && null!=endDate && startDate.length()>0 && endDate.length()>0){
            list = stageService.selectByDate(startDate,endDate);
        }
        mv.addObject("list",list);
        mv.setViewName("/declare/index");
        return mv;
    }
}
