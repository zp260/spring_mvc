package com.wt.tools;

/**
 * Created by mrz on 16/8/24.
 */
public class FilterUtil {
    /**
     * 过滤提交参数
     * @param value 要过滤的字符串
     * @return
     */
    public String filterDangerString(String value) {
        if (value == null) {
            return null;
        }
        value = value.replaceAll("\\|", "");

        value = value.replaceAll("&", "&");

        value = value.replaceAll(";", "");

        value = value.replaceAll("@", "");

        value = value.replaceAll("'", "");

        value = value.replaceAll("\"", "");

        value = value.replaceAll("‘","");

        value = value.replaceAll("\\”", "");

        value = value.replaceAll("<", "<");

        value = value.replaceAll(">", ">");

        value = value.replaceAll("\\(", "");

        value = value.replaceAll("\\)", "");

        value = value.replaceAll("\\+", "");

        value = value.replaceAll("\r", "");

        value = value.replaceAll("\n", "");

        value = value.replaceAll("script", "");

        value = value.replaceAll("'", "");
        value = value.replaceAll("\"", "");
        value = value.replaceAll(">", "");
        value = value.replaceAll("<", "");
        value = value.replaceAll("=", "");
        value = value.replaceAll("/", "");
        return value;
    }

    /**
     * 判断字符串中的字符是否包含非法字符
     * @param s 要检测的字符窜
     * @return
     */
    public static Boolean isContain(String s){
        //参数值为空也返回TRUE
        if (s.equals("")){
            return true;
        }
        boolean flag = false;
        String wrong = "|'\\(\\)\\+\n\r><;\\'\\|";//这里将文件路径写入数据库，暂时不过滤"双引号
        String scriptWrong = "script";
        for (String ss:s.split("")) {
            if (wrong.contains(ss)){
                System.out.println("包含有注入字符"+ss);
               return flag=false;
            }else {
                flag=true;
            }

        }
        if (scriptWrong.contains(s)){
            flag =false;
            System.out.println("包含有注入字符"+s);
        }
        return  flag;
    }
}
