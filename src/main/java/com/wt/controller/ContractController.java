package com.wt.controller;

import com.wt.model.Contract;
import com.wt.model.Stage;
import com.wt.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mrz on 16/7/14.
 */
@Controller
public class ContractController extends BaseController {
    @Autowired
    ContractService contractService;

    @RequestMapping("/conbase/add")
    public String addCon(@ModelAttribute Contract contract){

        return "/conbase/add";
    }

    @RequestMapping("/conbase/insert")
    public String insertCon(@ModelAttribute Contract contract){

        if (contract!=null){
            contractService.insert(contract);
        }
        return "redirect:/conbase/list";
    }

    @RequestMapping("/conbase/list")
    public ModelAndView conList(){
        List<Contract> conList = contractService.ContractList();
        return new ModelAndView("/conbase/list","list",conList);
    }


    @RequestMapping("/conbase/edit")
    public ModelAndView conEdit(@RequestParam int id,@ModelAttribute Contract contract){
        contract = contractService.getContractById(id);
        List<Boolean> inPort = new ArrayList<Boolean>();
        if(contract.getIsInport()){
            inPort.add(0,true);
            inPort.add(1,false);
        }else {
            inPort.add(0,false);
            inPort.add(1,true);
        }
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("contract",contract);
        map.put("inport",inPort);
        return new ModelAndView("/conbase/edit","map",map);
    }

    @RequestMapping("/conbase/update")
    public String conUpdate(@ModelAttribute Contract contract){
        if (contract!=null){
            contractService.update(contract);
        }

        return "redirect:/conbase/list";
    }

    @RequestMapping("/conbase/del")
    public String conDel(@RequestParam int id){
        contractService.delete(id);
        return "redirect:/conbase/list";
    }

    @RequestMapping("/conbase/verify")
    public String conVerify(@RequestParam int id){
        if (id>0){
            contractService.verify(id);
        }
        return "redirect:/conbase/list";
    }
}
