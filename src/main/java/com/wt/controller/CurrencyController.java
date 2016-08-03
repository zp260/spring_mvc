package com.wt.controller;

import com.wt.model.Currency;
import com.wt.services.CurrencyService;
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
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @RequestMapping("/currency/add")
    public String add(@ModelAttribute Currency currency){
        return "/currency/add";
    }

    @RequestMapping("/currency/insert")
    public String insert(@ModelAttribute Currency currency){
        if (currency!=null){
            currencyService.insert(currency);
        }
       return "redirect:/currency/list";
    }

    @RequestMapping("/currency/list")
    public ModelAndView list(){
        List<Currency> list = currencyService.list();
        return  new ModelAndView("/currency/list","list",list);
    }

    @RequestMapping("/currency/edit")
    public ModelAndView eidt(@RequestParam int id,@ModelAttribute Currency currency){
        Currency cur = new Currency();
        if (id>0){
            cur = currencyService.getMoneyById(id);
        }
        return new ModelAndView("/currency/edit","currency",cur);
    }

    @RequestMapping("/currency/update")
    public String update(@ModelAttribute Currency currency){
        if (currency!=null){
            currencyService.update(currency);
        }
        return "redirect:/currency/list";
    }

    @RequestMapping("/currency/del")
    public String del(@RequestParam int id){
        currencyService.delete(id);
        return  "redirect:/currency/list";
    }


}
