package com.wt.controller;

import com.wt.model.Finance;
import com.wt.services.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by mrz on 16/8/3.
 */
@Controller
public class FinanceController {

    @Autowired
    FinanceService financeService;

    @RequestMapping("/finance/add")
    public String add(@ModelAttribute Finance finance){
        return "/finance/add";
    }

    @RequestMapping("/finance/insert")
    public String insert(@ModelAttribute Finance finance){
        if (finance!=null){
            financeService.insert(finance);
        }
        return "redirect:/finance/list";
    }

    @RequestMapping("/finance/list")
    public ModelAndView list(){
        List<Finance> list = financeService.list();
        return  new ModelAndView("/finance/list","list",list);
    }

    @RequestMapping("/finance/edit")
    public ModelAndView edit(@ModelAttribute Finance one, @RequestParam int id){
        Finance finance1 = new Finance();
        if (id>0){
             finance1 =    financeService.getFinanceById(id);
            }
        return  new ModelAndView("/finance/edit","one",finance1);
    }

    @RequestMapping("/finance/update")
    public String update(@ModelAttribute Finance finance){
        if (finance!=null){
            financeService.update(finance);
        }
        return "redirect:/finance/list";
    }

    @RequestMapping("/finance/del")
    public String del(@RequestParam int id){
        if (id>0){
            financeService.delete(id);
        }
        return "redirect:/finance/list";
    }
}
