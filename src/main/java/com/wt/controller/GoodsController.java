package com.wt.controller;

import com.wt.model.Goods;
import com.wt.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mrz on 16/8/1.
 */
@Controller
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("/goods/insert")
    public void insertGood(@ModelAttribute Goods goods){
        if (goods !=null){
            goodsService.insertGoods(goods);
        }

    }

    @RequestMapping("/goods/add")
    public String addGood(@ModelAttribute Goods goods){
        return "/goods/add";
    }

    @RequestMapping("/goods/list")
    public ModelAndView goodsList(){
      List<Goods> list = goodsService.goodsList();
     return new ModelAndView("/goods/list","list",list);
    }

    @RequestMapping("/goods/editByid")
    public ModelAndView editGood(@RequestParam int id,@ModelAttribute Goods goods){

            Goods newgoods =  goodsService.getGoodById(id);


        return new ModelAndView("/goods/edit","good",newgoods);
    }

    @RequestMapping("/goods/editByName")
    public ModelAndView editGood(@ModelAttribute Goods goods,@RequestParam String goodname){

        Goods newgoods =  goodsService.getGoodByName(goodname);


        return new ModelAndView("/goods/edit","good",newgoods);
    }

    @RequestMapping("/goods/update")
    public String updateGoods(@ModelAttribute Goods goods){
        goodsService.updateGoods(goods);
        return "redirect:/goods/list";
    }
    @RequestMapping("/goods/del")
    public String delGood(@RequestParam int id){
        goodsService.deleteGoods(id);
        return "redirect:/goods/list";
    }
}
