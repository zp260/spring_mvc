package com.wt.controller;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import java.text.Format;
import java.text.ParseException;


/**
 * Created by mrz on 16/7/20.
 */

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
//通过对象 和 RESULTSET 设置 对象的每个属性的SET 方法
    public void getMethodInfo (Object object,ResultSet resultset) throws Exception{
        Class classType = object.getClass();
        Method[] methods =classType.getDeclaredMethods();
        Field[] fields = classType.getDeclaredFields();
        for (Field field:fields){
            String fieldName =  field.getName();
//            System.out.println("属性:"+field);
//            System.out.println(field.getName());
//            System.out.println("属性类型"+field.getType());
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


        }



//        for (Method method:methods){
//
////            System.out.println("方法:"+method);
//            System.out.println(method.getName());
//            Class<?>[] parameterTypes = method.getParameterTypes();
//            for (Class<?> clas:parameterTypes){
//                String parameterName = clas.getName();
//                if (parameterName!=null){
////                    System.out.println("参数类型:"+parameterName);
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

//    生成指定对象的所有属性的SQL INSERT的各个字段的语句
    //@object 要生成的对象
    //@dataBaseName 要插入的数据库表名
    //@extProperty 要排除的字段ID


    public String setInsertSql(Object object,String dataBaseName,String extProperty){
        Class classType = object.getClass();
        Field[] fields = classType.getDeclaredFields();

        String sqlStartStr = "INSERT INTO " + dataBaseName + " (" ;
        String sqlPropertyStr = "";
        String sqlStartValues= ") VALUES (";
        String sqlValues="";
        String sqlEndValues = ")";



        Object[] objects = new Object[fields.length-1];
        int j = 0;
        for (int i=0;i<fields.length;i++) {

            String fieldName =  fields[i].getName();
            PropertyDescriptor propertyDescriptor = null;
            try {
                propertyDescriptor = new PropertyDescriptor(fieldName,classType);
            } catch (IntrospectionException e) {
                e.printStackTrace();
            }
            Method fieldMethod = propertyDescriptor.getReadMethod();


            if (fieldName != extProperty){

                try {
                    objects[j] = fieldMethod.invoke(object,null);
                    j++;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                //最后一个字段不加逗号
                if (i== fields.length-1){
                    sqlPropertyStr +=   fieldName;
                    sqlValues += "?";
                }else {
                    sqlPropertyStr +=   fieldName + ",";
                    sqlValues += "?,";
                }
            }

        }
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("sql",sqlStartStr+sqlPropertyStr+sqlStartValues+sqlValues+sqlEndValues);
        map.put("object",objects);
        return sqlStartStr+sqlPropertyStr+sqlStartValues+sqlValues+sqlEndValues;
    }
//生成插入数据的序列对象
    public Object setInsertObj(Object object,String extProperty) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Class classType = object.getClass();
        Field[] fields = classType.getDeclaredFields();
        List<Object> list = new ArrayList<Object>();
        Object[] objects= new Object[]{};
        for (int i=0;i<fields.length;i++) {
            String fieldName = fields[i].getName();
            Class<?> fieldClass = fields[i].getType();
            if(fieldName != extProperty){
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName,classType);
                Method fieldMethod = propertyDescriptor.getReadMethod();
                System.out.println("stage."+fieldMethod.getName()+"(),");

                switch (fieldClass.getName()){
                    case "java.lang.String":
                        String value =  (String)fieldMethod.invoke(object,null);
                        list.add(value);
                        break;
                    case "java.math.BigDecimal":
                        BigDecimal decimalValue = (BigDecimal)fieldMethod.invoke(object,null);
                        list.add(decimalValue);
                        break;
                    case "int":
                        Integer intValue =  (Integer)fieldMethod.invoke(object,null);
                        list.add(intValue);
                        break;
                    case "java.lang.Boolean":
                        Boolean boolValue = (Boolean) fieldMethod.invoke(object,null);
                        list.add(boolValue);
                        break;
                }

            }
        }
        Object Objects = list ;
        return Objects;
    }

}
