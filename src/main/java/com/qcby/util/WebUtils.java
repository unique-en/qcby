package com.qcby.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WebUtils {
    public static ServletRequestAttributes getServletRequestAttributes(){
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    /**
     * 获取当前线程里的请求对象
     * @return
     */
    public static HttpServletRequest getHttpServletRequest(){
        return getServletRequestAttributes().getRequest();
    }
    /**
     * 获取当前线程里的响应对象
     * @return
     */
    public static HttpServletResponse getHttpServletResponse(){
        return getServletRequestAttributes().getResponse();
    }
    /**
     * 获取session对象
     * @return
     */
    public static HttpSession getHttpSession(){
        return getHttpServletRequest().getSession();
    }
    /**
     * 获取servletContext对象
     * @return
     */
    public static ServletContext getServletContext(){
        return getHttpSession().getServletContext();
    }
}

