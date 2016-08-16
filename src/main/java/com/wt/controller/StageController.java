package com.wt.controller;

import com.wt.model.Stage;
import com.wt.services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by mrz on 16/7/20.
 */
@Controller
public class StageController extends BaseController {
    @Autowired
    StageService stageService;

    @RequestMapping("/stage/list")
    public ModelAndView list(){
        List<Stage> list = stageService.getStageList();
        return new ModelAndView("/stage/list","list",list);
    }

    @RequestMapping("/stage/add")
    public String add(@ModelAttribute Stage stage){

        return "/stage/add";
    }

    @RequestMapping("/stage/insert")
    public String insert(@ModelAttribute Stage stage){
        if (stage!=null){
            stageService.insert(stage);
        }


        return "redirect:/stage/list";
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
    @RequestMapping("/stage/upload")
    public String upload(){
        return "/stage/upload";
    }
}
