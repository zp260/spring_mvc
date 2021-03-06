package com.wt.controller;

import com.wt.controller.util.CallbackMap;
import com.wt.controller.util.UserPowerMap;
import com.wt.model.Goods;
import com.wt.searchBean.GoodAndCon;
import com.wt.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = {"/goods/list","/goods"})
    public ModelAndView goodsList(){
     return new ModelAndView("/goods/list");
    }
    @RequestMapping(value = "/goods/search",method = RequestMethod.POST)
    public  ModelAndView searchList(@RequestParam(value = "filedName")String filedName,@RequestParam(value = "value")String value){
        List<GoodAndCon> list = goodsService.search(filedName,value);
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
    public ModelAndView updateGoods(@ModelAttribute Goods goods){
        ModelAndView mv = new ModelAndView();
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            if(null!=goods.getConSN() && null!=goods.getStageNum() && goods.getGoodsId()>0){
                goodsService.updateGoods(goods);
                map = new CallbackMap("修改成功",true,null).getCallBackMap();
            }
        }catch (NullPointerException e){
            map = new CallbackMap("修改失败",false,"ID参数错误").getCallBackMap();
        }
        mv.setView(new MappingJackson2JsonView());
        mv.addAllObjects(map);
        return mv;
    }
    @ResponseBody
    @RequestMapping(value = "/goods/del",produces = {"application/json;charset=UTF-8"})
    public ModelAndView delGood(@RequestParam int id){
        ModelAndView mv = new ModelAndView();
        Map<String,Object> map = new CallbackMap("删除成功",true,null).getCallBackMap();
        goodsService.deleteGoods(id);
        mv.setView(new MappingJackson2JsonView());
        mv.addAllObjects(map);
        return mv;
    }
    @ResponseBody
    @RequestMapping(value = "/goods/getByConStage",produces = {"application/json;charset=UTF-8"})
    public ModelAndView delGood(@RequestParam String conSn,@RequestParam("stageNum")String stageNum){
        ModelAndView mv = new ModelAndView();
        Map<String,Object> map = new CallbackMap("数据获取成功",true,null).getCallBackMap();
        mv.setView(new MappingJackson2JsonView());
        mv.addAllObjects(map);
        return mv;
    }
}
