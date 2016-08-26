package com.wt.interceptor;

import com.sun.org.apache.bcel.internal.classfile.Utility;
import com.wt.auth.AuthorityHelper;
import com.wt.auth.AuthorityType;
import com.wt.auth.FireAuthority;
import com.wt.auth.ResultTypeEnum;
import com.wt.controller.util.SessionHelper;
import com.wt.model.User;
import com.wt.tools.FilterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Enumeration;

/**
 * Created by mrz on 16/8/15.
 */
public class AuthorityAnnotationInterceptor extends HandlerInterceptorAdapter {
    final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {//判断是否CONTROOLER ，还是静态资源
//-------------------------------------------过滤提交数据-----------------------------------------------------------------
            Enumeration<String> names = request.getParameterNames();
            while (names.hasMoreElements()) {
                String name = names.nextElement();

                String[] values = request.getParameterValues(name);
                for (String value : values) {
                    if (!FilterUtil.isContain(value)){
//                        //返回HTML
//                        StringBuilder sb = new StringBuilder();
//                        sb.append(request.getContextPath());
//                        sb.append("/error?oprst=false&opmsg=").append(URLEncoder.encode("您提交的字符含有非法字符，请不要尝试注入", "utf-8"));
//                        response.sendRedirect(sb.toString());

                        //JSON返回
                        //采用ajax方式的进行提示
                        response.setCharacterEncoding("utf-8");
                        response.setContentType("text/html;charset=UTF-8");
                        OutputStream out = response.getOutputStream();
                        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out, "utf-8"));
                        pw.println("{\"success\":false,\"code\":12,\"info\":\"您提交的字符含有非法字符，请不要尝试注入\"}");
                        pw.flush();
                        pw.close();
                        return false;
                    }
                }
            }
// ----------------------------------------------权限验证部分-------------------------------------------------------------
            HandlerMethod handler2 = (HandlerMethod) handler;
            FireAuthority fireAuthority = handler2.getMethodAnnotation(FireAuthority.class);
            //没有声明权限验证的,放行
            if (null == fireAuthority) {

                return true;
            }

            logger.debug("fireAuthority", fireAuthority.toString());

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(SessionHelper.UserHandler); //通过SEESION 取登陆后的USER
            if (null == user) {
                response.sendRedirect("/index?error=error");
                return false;
            }
            boolean aflag = false;

            for (AuthorityType at : fireAuthority.authorityTypes()) {
                if (AuthorityHelper.hasAuthority(at.getIndex(), user.getRightContent()) == true) {
                    aflag = true;
                    break;
                }
            }


            if (false == aflag) {

                if (fireAuthority.resultType() == ResultTypeEnum.page) {
                    //采用传统页面进行提示
                    StringBuilder sb = new StringBuilder();
                    sb.append(request.getContextPath());
                    sb.append("/error?oprst=false&opmsg=").append(URLEncoder.encode("没有权限", "utf-8"));
                    response.sendRedirect(sb.toString());
                } else if (fireAuthority.resultType() == ResultTypeEnum.json) {
                    //采用ajax方式的进行提示
                    response.setCharacterEncoding("utf-8");
                    response.setContentType("text/html;charset=UTF-8");
                    OutputStream out = response.getOutputStream();
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(out, "utf-8"));
                    pw.println("{\"result\":false,\"code\":12,\"errorMessage\":\"没有权限\"}");
                    pw.flush();
                    pw.close();
                }

                return false;

            }
        }
        return true;
    }

}
