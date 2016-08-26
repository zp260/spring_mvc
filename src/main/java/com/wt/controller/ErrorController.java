package com.wt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mrz on 16/8/24.
 */
@Controller
public class ErrorController {

    @RequestMapping("/error")
    public ModelAndView error(@RequestParam(value = "opmsg",required = true) String opmsg,@RequestParam(value = "oprst",required = false) boolean oprst){
        ModelAndView mv =new ModelAndView();
        mv.addObject("opmsg",opmsg);
        mv.setViewName("/error");
        return mv;
    }
}
