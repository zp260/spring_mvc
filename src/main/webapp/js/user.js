
/**
 * Created by mrz on 16/8/18.
 */
/*---------------------------------validform参数表----------------------------------------------------------------------*/
var rule6_20={
    "/^(\w){6,20}$/":/^(\w){6,20}$/ //只能输入6-20个字母、数字、下划线
};
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
var rule_zh = /^[\u4E00-\u9FA5\uf900-\ufa2d]{2,6}$/;  //必须是2到6位中文字符
$().Validform({
    datatype:{
        "zh2-6":rule_zh,
        "username":rule_userName,
        "/^(\w){6,20}$/":/^(\w){6,20}$/
    }
});
/*---------------------------------validform参数表----------------------------------------------------------------------*/

function setPower(){
    var select_id =  $("#userPower option:selected").val();
    switch (select_id)
    {

        case "0":
//               $("input[name='userPower']:checkbox[value='"+12+"']").prop("checked",true);设置指定VALUE为CHECKED
            makeCheckBox([11]);
            break;
        case "1":
            var powerlist = new Array(8,10,11,12,14);
            makeCheckBox(powerlist);
            break;
        case "2":
            makeCheckBox([9,11]);
            break;
        case "3":
            makeCheckBox([0,1,2,3,8,9,10,11,12,13,14]);
            break;
        case "4":
            makeCheckBox([4,5,6,7,11]);
            break;
        case "5":
            makeCheckBox([0,1,2,3,7,8,9,10,11,12,13,14]);
            break;
    }
}
function makeCheckBox(arr){
    $("input[name='rightContent']").val(arr);
}
function makeSelect(value){
    $("#userPower").val(value);
}


//校验密码：只能输入6-20个字母、数字、下划线
function isPasswd(s)
{
    var patrn=/^(\w){6,20}$/;
    if (!patrn.exec(s)) return false
    return true
}
//校验登录名：只能输入5-20个以字母开头、可带数字、“_”、“.”的字串
function isRegisterUserName(s)
{
    var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;
    if (!patrn.exec(s)) return false
    return true
}
//校验手机号码：必须以数字开头，除数字外，可含有“-”
function isMobil(s)
{
    var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
    if (!patrn.exec(s)) return false
    return true
}
//$(function () {
//    var ok1=false;
//    var ok2=false;
//    var ok3=false;
//    var ok4=false;
//    // 验证用户名
//    $('input[name="loginName"]').focus(function(){
//        $(this).next().text('只能输入5-20个以字母开头、可带数字、“_”、“.”的字串').removeClass('state1').addClass('state2');
//    }).blur(function(){
//        if(isRegisterUserName($(this).val())){
//            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
//            ok1=true;
//        }else{
//            $(this).next().text('只能输入5-20个以字母开头、可带数字、“_”、“.”的字串').removeClass('state1').addClass('state3');
//        }
//
//    });
//    //验证密码
//    $('input[name="passWord"]').focus(function(){
//        $(this).next().text('密码应该为6-20位之间').removeClass('state1').addClass('state2');
//    }).blur(function(){
//        if(isPasswd($(this).val())){
//            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
//            ok2=true;
//        }else{
//            $(this).next().text('密码应该为6-20位之间').removeClass('state1').addClass('state3');
//        }
//
//    });
//
//    //验证确认密码
//    $('input[name="repeatPass"]').focus(function(){
//        $(this).next().text('输入的确认密码要和上面的密码一致,规则也要相同').removeClass('state1').addClass('state2');
//    }).blur(function(){
//        if(isPasswd($(this).val()) && $(this).val() == $('input[name="passWord"]').val()){
//            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
//            ok3=true;
//        }else{
//            $(this).next().text('输入的确认密码要和上面的密码一致,规则也要相同哦').removeClass('state1').addClass('state3');
//        }
//
//    });
//    //提交按钮,所有验证通过方可提交
//    $('.submit').click(function(){
//        if(ok2 && ok3){
//            $('#userPass').submit();
//        }else{
//            return false;
//        }
//    });
//});
