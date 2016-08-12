package com.wt.controller;

import com.wt.model.Stage;
import com.wt.services.StageService;
import com.wt.tools.Ftp;
import com.wt.tools.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
