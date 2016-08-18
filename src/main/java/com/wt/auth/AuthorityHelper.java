package com.wt.auth;

/**
 * Created by mrz on 16/8/15.
 */
public class AuthorityHelper {

    /**
     * 250个0
     */
    final public static String _RAW = "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

    final public static String _RAW_ON = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";

    /**
     * 判断是否有权限
     * @param akey 权限位置
     * @param session 取得的用户SEESION存储的权限
     * @return
     */
    public static boolean hasAuthority(int akey, String session){

        if(session==null || "".equals(session)){
            return false;
        }

        char value = session.charAt(akey);
        if(value == '1'){
            return true;
        }

        return false;
    }

    /**
     * 创建权限字符串
     * @param akeys 有权限的项,比如 1,3,6,11,20
     * @return 权限字符串, 比如0101001001000000000
     */
    public static String makeAuthority(String akeys){
        StringBuilder sb = new StringBuilder(_RAW);
        String []akeys_s = akeys.split(",");
        for(String akey: akeys_s){
            if(null == akey || "".equals(akey)){
                continue;
            }
            int ak = Integer.parseInt(akey);
            sb.setCharAt(ak, '1');
        }

        return sb.toString();
    }



}
