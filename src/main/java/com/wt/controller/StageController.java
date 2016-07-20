package com.wt.controller;

import com.wt.model.Stage;
import com.wt.services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by mrz on 16/7/20.
 */
@Controller
public class StageController {
    @Autowired
    StageService stageService;

}
