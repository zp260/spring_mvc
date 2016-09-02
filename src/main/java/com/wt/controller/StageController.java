package com.wt.controller;

import com.wt.controller.util.CallbackMap;
import com.wt.model.Stage;
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

    @RequestMapping("/stage/list")
    public ModelAndView list(@RequestParam(value = "conSN",required = false)String conSN){
        List<Stage> list = new ArrayList<Stage>();
        if ("".equals(conSN) || null==conSN){
            list = stageService.getStageList();
        }else {
            list = stageService.getStageListByConSN(conSN);
        }
        return new ModelAndView("/stage/list","list",list);
    }

    @RequestMapping("/stage/add")
    public String add(@ModelAttribute Stage stage){

        return "/stage/add";
    }
    @ResponseBody
    @RequestMapping(value = "/stage/insert",produces = {"application/json;charset=UTF-8"})
    public ModelAndView insert(@ModelAttribute Stage stage){
        Map<String,Object> map = new HashMap<String, Object>();
        if (stage!=null){
            int stageNum = stageService.getStageNumByContract(stage.getConSN());
            stage.setStageNum(stageNum);
            stageService.insert(stage);
            map =  new CallbackMap("批次信息增加成功",true,null).getCallBackMap();
            map.put("stageNum",stageNum);
        }else {
            map =  new CallbackMap("批次信息输入不正确",false,"批次信息为空").getCallBackMap();
        }
        return new ModelAndView (new MappingJackson2JsonView(),map);
    }

    @RequestMapping("/stage/update")
    public String update(@ModelAttribute Stage stage){
        if (stage!=null){
            stageService.update(stage);
        }
        return "redirect:/stage/list";

    }

    @RequestMapping("/stage/edit")
    public ModelAndView edit(@RequestParam int id,@ModelAttribute Stage stage){
       Stage stage1 = stageService.getStageById(id);
        return new ModelAndView("/stage/edit","stage",stage1);
    }

}
