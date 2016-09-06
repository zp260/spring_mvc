package com.wt.controller;

import com.wt.auth.AuthorityType;
import com.wt.auth.FireAuthority;
import com.wt.controller.util.CallbackMap;
import com.wt.model.*;
import com.wt.services.ContractService;
import com.wt.services.CurrencyService;
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
    @Autowired
    CurrencyService currencyService;
    @Autowired
    PortService portService;
    @Autowired
    StageService stageService;

    @FireAuthority(authorityTypes = AuthorityType.Contract_CREATE)
    @RequestMapping("/conbase/add")
    public ModelAndView addCon(@ModelAttribute Contract contract, @ModelAttribute Stage stage, @ModelAttribute Goods goods){
        ModelAndView mv = new ModelAndView();
        List<Currency> currencyList =currencyService.list();
        List<Port> portList = portService.getPortList();
        mv.addObject("currencyList",currencyList);
        mv.addObject("portList",portList);
        mv.setViewName("/conbase/entry");
        return mv;
    }
    @FireAuthority(authorityTypes = AuthorityType.Contract_CREATE)
    @ResponseBody
    @RequestMapping(value = "/conbase/insert",produces = {"application/json;charset=UTF-8"})
    public ModelAndView insertCon(@ModelAttribute Contract contract){
        Map<String,Object> map = new HashMap<String, Object>();
        if (contract!=null && null!=contract.getConSN() && ""!=contract.getConSN()){
            if (!contractService.hasContract(contract.getConSN())){ //判断如果不存在已有合同就写入
                contractService.insert(contract);
                 map =  new CallbackMap("合同信息增加成功",true,null).getCallBackMap();
            }
            else {
                map =  new CallbackMap("已存在此合同号的合同",false,"合同已存在").getCallBackMap();
            }

        }else {
            map =  new CallbackMap("合同信息输入不完整",false,"合同号未输入").getCallBackMap();
        }

        return new ModelAndView (new MappingJackson2JsonView(),map);
    }

    /**
     * 根据合同号查询合同
     * @param id     合同ID
     * @param conSN  合同号
     * @param contract
     * @param stage
     * @return
     */
    @FireAuthority(authorityTypes = AuthorityType.Contract_FIND)
    @RequestMapping("/conbase/list")
    public ModelAndView conList(@RequestParam(value = "id",required = false) Integer id,@RequestParam(value = "conSN",required = false)String conSN,@ModelAttribute Contract contract,@ModelAttribute Stage stage){

        Contract oneContract = new Contract();
        ModelAndView mv = new ModelAndView();
        Integer stageNum=0;
        if (null !=id && id>0){
            oneContract = contractService.getContractById(id);
            if (null!=oneContract){
                stageNum = stageService.getStageNumByContract(oneContract.getConSN());
                mv.addObject(oneContract);
            }


        }else if (null != conSN){
            oneContract = contractService.getContractByConSN(conSN);
            if (null!=oneContract){
                stageNum = stageService.getStageNumByContract(oneContract.getConSN());
                mv.addObject(oneContract);
            }
        }
        else {
            List<Contract> conList = contractService.ContractList();
            mv.addObject("list",conList);
        }

        mv.addObject("stageNum",stageNum);
        mv.setViewName("/conbase/list");
        return mv;
    }

    /**
     *
     * @param fieldName 字段名称
     * @param value 字段值
     * @param contract
     * @param stage
     * @return
     */
    @RequestMapping("/conbase/search")
    public ModelAndView conList(@RequestParam(value = "fieldName",required = true)String fieldName,@RequestParam(value = "value")String value,@ModelAttribute Contract contract,@ModelAttribute Stage stage){

        ModelAndView mv = new ModelAndView();
        List<Contract> conList = new ArrayList<Contract>();
        if (null!=fieldName && null!=value){
            if (fieldName.equals("goodsName")){
                conList = contractService.getConByGood(value);
            }else {
                conList = contractService.selectAll(fieldName,value);
            }
        }
        mv.addObject("list",conList);
        mv.setViewName("/conbase/list");
        return mv;
    }

    /**
     * 根据合同签订时间查询
     * @param start 合同开始时间
     * @param end   搜索结束时间
     * @param contract
     * @param stage
     * @return      符合的合同列表
     */
    @RequestMapping("/conbase/searchByDate")
    public ModelAndView conListByDate(@RequestParam(value = "start")String start,@RequestParam(value = "end")String end,@ModelAttribute Contract contract,@ModelAttribute Stage stage){

        ModelAndView mv = new ModelAndView();
        List<Contract> conList = new ArrayList<Contract>();
        if (null!=start && null!=end){
            conList = contractService.getConByDate(start,end);
        }
        mv.addObject("list",conList);
        mv.setViewName("/conbase/list");
        return mv;
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
