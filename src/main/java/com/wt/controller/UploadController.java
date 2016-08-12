package com.wt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrz on 16/8/12.
 */
@Controller
public class UploadController {
    @ResponseBody
    @RequestMapping(value ="/fileupload",produces = {"application/json;charset=UTF-8"})
    public ModelAndView fileupload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String fileName = file.getOriginalFilename();
        Map<String,Object> map = new HashMap<String, Object>();

        //判断文件类型
        if (checkFile(fileName)){

            //判断文件大小
            if((file.getSize()/1024)>102400){
                System.out.println("文件大于100M");
                map.put("success",false);
                map.put("error","文件大于100M");
            }else {
                map.put("success",true);
                //上传开始时间
                long  startTime=System.currentTimeMillis();

                String webPath = "/upload/"+fileName; //网站的相对路径
                String filePath = request.getSession().getServletContext().getRealPath("/upload/");
                String uploadPath = filePath+fileName; //服务器上存储的绝对路径
                File newFile = new File(uploadPath);  //写入服务器文件

                //写入上传文件
                file.transferTo(newFile);
                map.put("path",webPath);
                //上传结束时间
                long  endTime=System.currentTimeMillis();
                System.out.println("方法二的运行时间："+String.valueOf(endTime-startTime)+"ms");
            }

        }else {
            map.put("success",false);
            map.put("error","上传文件类型不对");
        }


        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    //判断上传文件的类型
    private  boolean checkFile(String fileName){
        boolean flag=false;
        String suffixList="xls,xlsx,jpg,gif,png,ico,bmp,jpeg,pdf,doc";
        //获取文件后缀
        String suffix=fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());

        if(suffixList.contains(suffix.trim().toLowerCase())){
            flag=true;
        }
        return flag;
    }
}
