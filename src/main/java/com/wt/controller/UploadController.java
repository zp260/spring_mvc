package com.wt.controller;



import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
/**
 * Created by mrz on 16/8/9.
 */

public class UploadController {
    public static final String  SERVER="101.200.1.246";
    public static final int PORT=21;
    public static final String LOGINNAME="mrz";
    public static final String PASSWORD="vmvnv1v2";
    /**
     * 上传文件
     *
     * @param fileName 文件名称
     * @param plainFilePath 明文文件路径路径
     * @param filepath 文件路径
     * @return
     * @throws Exception
     */
    public static String fileUploadByFtp(String plainFilePath,String fileName,String filepath)throws Exception{

        FileInputStream fis = null;
        ByteArrayOutputStream bos =null;
        FTPClient ftpClient =new FTPClient();
        String bl="false";

        try {
            fis = new FileInputStream(plainFilePath);
            bos = new ByteArrayOutputStream(fis.available());
            byte[] buffer = new byte[1024];
            int count = 0;

            while ((count = fis.read(buffer))!=-1){
                bos.write(buffer,0,count);
            }
            bos.flush();

            ftpClient.connect(SERVER,PORT);
            ftpClient.login(LOGINNAME,PASSWORD);
            FTPFile[] fs;
            fs = ftpClient.listFiles();
            for (FTPFile ff : fs){
                if ( (ff.getName().equals(filepath))){
                    bl = "true";
                    ftpClient.changeWorkingDirectory("/"+filepath);
                }
            }

            if ("false".equals(bl)){
                System.out.println("文件路径不存在:"+"/"+filepath);
                return bl;
            }
            ftpClient.setBufferSize(1024);
            ftpClient.setControlEncoding("GBK");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.storeFile(fileName,fis);
            System.out.println("上传文件成功:"+fileName+"文件保存路径:"+"/" +filepath+"/");
            return bl;
        }catch (Exception e){
            throw e;
        }finally {
            if (fis!=null){
                try {
                    fis.close();
                }catch (Exception e){
                    System.out.println(e.getLocalizedMessage()+"E:"+e);
                }
            }

            if (bos!=null){
                try {
                    bos.close();
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage()+"E:"+e);
                }
            }
        }
    }
}
