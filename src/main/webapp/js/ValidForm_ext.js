/**
 * Created by mrz on 16/8/30.
 */
/*---------------------------------validform参数表----------------------------------------------------------------------*/

/***
 *
 * @param gets      获取到的表单元素值
 * @param obj       当前表单元素
 * @param curform   当前验证的表单
 * @param regxp     内置的一些正则表达式的引用
 * @returns {boolean}
 */
var rule_userName = function(gets,obj,curform,regxp){
    alert(gets.length);
    var reg1=/^[\w\.]{4,16}$/,
        reg2=/^[\u4E00-\u9FA5\uf900-\ufa2d]{2,8}$/;

    if(reg1.test(gets)){return true;}
    if(reg2.test(gets)){return true;}
    return false;

    //注意return可以返回true 或 false 或 字符串文字，true表示验证通过，返回字符串表示验证失败，字符串作为错误提示显示，返回false则用errmsg或默认的错误提示;
};
var rule6_20= /^(\w){6,20}$/; //只能输入6-20个字母、数字、下划线
var rule_zh = /^[\u4E00-\u9FA5\uf900-\ufa2d]{2,6}$/;  //必须是2到6位中文字符
var rule_zh2_20 = /^[\u4E00-\u9FA5\uf900-\ufa2d]{2,30}$/;  //必须是2到6位中文字符
var rule_nums = /^-?[1-9]+(\.\d+)?$|^-?0(\.\d+)?$|^-?[1-9]+[0-9]*(\.\d+)?$/; //验证数字以及小数点
var rule_date = /^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/;//日期验证
$().Validform({
    datatype:{
        "zh2-6":rule_zh,
        "zh2-30":rule_zh2_20,
        "rule_nums":rule_nums,
        "username":rule_userName,
        "rule_date":rule_date,
        "/^(\w){6,20}$/":rule6_20
    }
});
/*---------------------------------validform参数表----------------------------------------------------------------------*/