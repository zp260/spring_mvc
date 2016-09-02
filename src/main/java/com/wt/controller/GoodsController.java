package com.wt.controller;

import com.wt.controller.util.CallbackMap;
import com.wt.controller.util.UserPowerMap;
import com.wt.model.Goods;
import com.wt.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * Created by mrz on 16/8/1.
 */
@Controller
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @ResponseBody
    @RequestMapping(value = "/goods/insert",produces = {"application/json;charset=UTF-8"})
    public ModelAndView insertGood(@ModelAttribute Goods goods){
        Map<String,Object> map =new HashMap<String, Object>();
        if (goods.getConSN().equals("")){ //这里还要加个判断 CONSN 和 STAGENUM
            if (goods.getStageNum()<0){
                map = new CallbackMap("设备增加失败",false,"批次号不正确").getCallBackMap();
            }
            else {
                map = new CallbackMap("设备增加失败",false,"合同号不正确").getCallBackMap();
            }

        }else{
            goodsService.insertGoods(goods);
            map = new CallbackMap("设备增加成功",true,null).getCallBackMap();

        }
        return  new ModelAndView(new MappingJackson2JsonView(),map);
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
