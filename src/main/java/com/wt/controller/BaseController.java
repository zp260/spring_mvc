package com.wt.controller;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import java.text.Format;
import java.text.ParseException;


/**
 * Created by mrz on 16/7/20.
 */
@Controller
public class BaseController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {

         binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
    public String convertTime(long time){
        Date date = new Date(time);
        Format format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date).toString();
    }

    public Date Str2Date(String DateStr){

      Date date =new Date();
      try {

          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          date = (Date)sdf.parse(DateStr);
          return date;
      }
      catch (ParseException e)
      {
          System.out.println(e.getMessage());
      }
        return date;
    }

    public void getMethodInfo (Object object,ResultSet resultset) throws Exception{
        Class classType = object.getClass();
        Method[] methods =classType.getDeclaredMethods();
        Field[] fields = classType.getDeclaredFields();
        for (Field field:fields){
            String fieldName =  field.getName();
            System.out.println("属性:"+field);
            System.out.println(field.getName());
            System.out.println("属性类型"+field.getType());
            Class<?> fieldClass = field.getType();



            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(),classType);
            Method fieldMethod = propertyDescriptor.getWriteMethod();

            switch (fieldClass.getName()){
                case "java.lang.String":
                    fieldMethod.invoke(object,resultset.getString(fieldName));
                    break;
                case "java.math.BigDecimal":
                    fieldMethod.invoke(object,resultset.getBigDecimal(fieldName));
                    break;
                case "int":
                    fieldMethod.invoke(object,resultset.getInt(fieldName));
                    break;
                case "java.lang.Boolean":
                    fieldMethod.invoke(object,resultset.getBoolean(fieldName));
                    break;
            }

            System.out.println("ok");

        }



//        for (Method method:methods){
//
//            System.out.println("方法:"+method);
//            System.out.println(method.getName());
//            Class<?>[] parameterTypes = method.getParameterTypes();
//            for (Class<?> clas:parameterTypes){
//                String parameterName = clas.getName();
//                if (parameterName!=null){
//                    System.out.println("参数类型:"+parameterName);
////                    method.invoke(object,1);
//
//                    switch (parameterName) {
//
//                        case "java.lang.String":
//                            method.invoke(object,"stringssss");
//                            break;
//                        case "java.math.BigDecimal":
//                            method.invoke(object,new BigDecimal(2001));
//                            break;
//                        case "int":
//                            method.invoke(object,5678);
//                            break;
//                        case "java.lang.Boolean":
//                            method.invoke(object,true);
//                            break;
//                    }
//
//
//                }else {
//                    System.out.println("无参数类型:"+parameterName);
//                }
//
//
//
//            }
//        }
    }
}
