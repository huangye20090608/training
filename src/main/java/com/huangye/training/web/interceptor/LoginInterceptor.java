package com.huangye.training.web.interceptor;

import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by huangye on 2017/3/30.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String returnURL = "";
        if(StringUtils.isBlank("")){
            returnURL = request.getRequestURL().toString();
            return false;
        }
        return true;
    }


    protected String getLoginInfoCookieValue(HttpServletRequest request){
        String result = null;
        String cookieName = "";
        LOGGER.info("开始读取cookie名："+cookieName);
        Cookie cookies[] = request.getCookies();
        if(cookies != null){
            for(int i = 0; i < cookies.length; i ++){
                if(cookies[i].getName().equalsIgnoreCase(cookieName)){
                    result = cookies[i].getValue();
                    break;
                }
            }
        }
        LOGGER.info("获取cookie完成：cookie值:"+result);
        return result;
    }
}
