package com.wt.controller;

import com.wt.controller.util.CallbackMap;
import com.wt.model.Goods;
import com.wt.model.Port;
import com.wt.model.Stage;
import com.wt.services.GoodsService;
import com.wt.services.PortService;
import com.wt.services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mrz on 16/7/20.
 */
@Controller
public class StageController {
    @Autowired
    StageService stageService;
    @Autowired
    PortService portService;
    @Autowired
    GoodsService goodsService;

    @RequestMapping("/stage/list")
    public ModelAndView list(@RequestParam(value = "conSN",required = false)String conSN){
        List<Stage> list = new ArrayList<Stage>();
        if (null==conSN){
            list = stageService.getStageList();
        }else if("".equals(conSN)){
            list = stageService.getStageList();
        }else {
            list = stageService.getStageListByConSN(conSN);
        }
        return new ModelAndView("/stage/list","list",list);
    }

    /**
     * HTML 根据批次号获取STAGE信息HTML版本
     * @param num
     * @param conSN
     * @param stage
     * @return
     */
    @RequestMapping(value = "/stage/getByNumHtml")
    public ModelAndView stageByNum(@RequestParam(value = "num")Integer num, @RequestParam(value = "consn")String conSN, @ModelAttribute Stage stage, @ModelAttribute Goods goods){
        ModelAndView mv  =new ModelAndView();
        Map<String,Object> map= new HashMap<String, Object>();
        List<Goods> goodsList = new ArrayList<Goods>();
        if (num!=null && conSN!=null){
            stage =  stageService.getStageByStageNum(num,conSN);
            goodsList = goodsService.goodsListByConStage(conSN,num);
        }
        List<Port> portList = portService.getPortList();
        mv.addObject("portList",portList);
        mv.addObject(stage);
        mv.addObject("goodsList",goodsList);
        mv.setViewName("/stage/getByNumHtml");
        return mv;
    }
    /**
     * json 根据批次号获取STAGE信息JSON版本
     * @param num
     * @param conSN
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/stage/getByNum",produces = {"application/json;charset=UTF-8"})
    public ModelAndView stageByNum(@RequestParam(value = "num")Integer num,@RequestParam(value = "consn")String conSN){
        Stage onestage = new Stage();
        Map<String,Object> map= new HashMap<String, Object>();
        if (num!=null && conSN!=null){
            onestage =  stageService.getStageByStageNum(num,conSN);
            map.put("stage",onestage);
        }

       return new ModelAndView(new MappingJackson2JsonView(),map);

    }
    @RequestMapping("/stage/add")
    public String add(@ModelAttribute Stage stage){

        return "/stage/add";
    }
    @ResponseBody
    @RequestMapping(value = "/stage/insert",produces = {"application/json;charset=UTF-8"})
    public ModelAndView insert(@ModelAttribute Stage stage){
        Map<String,Object> map = new HashMap<String, Object>();
        if (stage!=null && stage.getConSN()!=null){
            stageService.insert(stage);
            map =  new CallbackMap("批次信息增加成功",true,null).getCallBackMap();
        }else {
            map =  new CallbackMap("批次信息输入不正确",false,"批次信息为空").getCallBackMap();
        }
        return new ModelAndView (new MappingJackson2JsonView(),map);
    }
    @ResponseBody
    @RequestMapping(value = "/stage/update",produces = {"application/json;charset=UTF-8"})
    public ModelAndView update(@ModelAttribute Stage stage){
        Map<String,Object> map = new HashMap<String, Object>();
        if (stage!=null&& stage.getConSN()!=null){
            stage.getCdPdf().length();
            stageService.update(stage);
            map =  new CallbackMap("批次信息修改成功",true,null).getCallBackMap();
        }else {
            map =  new CallbackMap("批次信息修改失败",false,"信息提交有误").getCallBackMap();
        }
        return new ModelAndView (new MappingJackson2JsonView(),map);

    }

    @RequestMapping("/stage/edit")
    public ModelAndView edit(@RequestParam int id,@ModelAttribute Stage stage,@ModelAttribute Goods goods){
        ModelAndView mv=new ModelAndView("/stage/edit");
        stage = stageService.getStageById(id);
        List<Goods> goodsList = new ArrayList<Goods>();
        List<Port> portList = portService.getPortList();
        String conSN = stage.getConSN();
        Integer stageNum = stage.getStageNum();
        if(null!=stage && null!=conSN && null!=stageNum){
            goodsList = goodsService.goodsListByConStage(conSN,stageNum);
        }
        mv.addObject("goodsList",goodsList);
        mv.addObject("portList",portList);
        mv.addObject(stage);
        return mv;
    }

}
