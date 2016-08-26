package com.wt.controller;

import com.wt.tools.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrz on 16/8/12.
 */
@Controller
public class UploadController {

    @RequestMapping(value ="/uploads",produces = {"application/json;charset=UTF-8"})
    public String upload(){
        return "/upload";
    }
    @RequestMapping(value ="/test",produces = {"application/json;charset=UTF-8"})
    public String uploads(){
        return "/test";
    }

    /**
     * 处理文件上传
     * @param file
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value ="/fileupload",produces = {"application/json;charset=UTF-8"})
    public ModelAndView fileupload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = file.getOriginalFilename();
        Map<String,Object> map = new HashMap<String, Object>();

        //判断文件类型
        if (checkFile(fileName)){

            //判断文件大小
            if((file.getSize()/1024)>102400){

                map.put("success",false);
                map.put("error","文件大于100M");
            }else {


                //存储在服务器上的基本路径
                String serverFilePath = request.getSession().getServletContext().getRealPath("/")+"upload";
                //生成以上传日期为主的文件夹
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
                String ymd = sdf.format(new Date());
                serverFilePath+=File.separator+ymd+File.separator;
                //判断是否存在文件夹
                File directory = new File(serverFilePath);
                if (!directory.exists()){
                    directory.mkdirs();
                }
                try {
                    //生成新的文件名 MD(文件)取值文件名
                    String newFileName = getFileMd5(file);
                    String uploadPath = serverFilePath+newFileName+getFileSuffix(fileName); //服务器上存储的绝对路径
                    File newFile = new File(uploadPath);  //写入服务器文件的完整位置

                    //写入上传文件
                    file.transferTo(newFile);
                    String webPath = File.separator+"upload"+File.separator+ymd+File.separator+newFileName+getFileSuffix(fileName); //网站的相对路径
                    map.put("success",true);
                    map.put("path",webPath);

                    System.out.println("上传成功:"+webPath);
                } catch (Exception e) {
                    map.put("error","生成服务器文件出错");
                    e.printStackTrace();
                }

            }

        }else {
            map.put("success",false);
            map.put("error","上传文件类型不对");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }


    /**
     * 判断上传文件的类型
     * @param fileName 文件名
     * @return 返回是否符合上传文件类型
     */
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

    /**
     * 获取文件扩展名
     * @param fileName 文件全名
     * @return 返回文件后缀名
     */
    private  String getFileSuffix(String fileName){
        //获取文件后缀
        String suffix=fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
        return "."+suffix;
    }

    public String getFileMd5(CommonsMultipartFile upload) throws Exception {
        byte[] uploadBytes = upload.getBytes();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(uploadBytes);
        String hashString = new BigInteger(1, digest).toString(16);
        return hashString.toUpperCase();
    }
}
