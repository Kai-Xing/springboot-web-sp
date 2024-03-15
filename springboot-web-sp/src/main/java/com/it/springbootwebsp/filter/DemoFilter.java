package com.it.springbootwebsp.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    //只调用一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init方法执行");
        //Filter.super.init(filterConfig);
    }

    //调用多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Demo 拦截到请求");
        System.out.println("Demo 放行");
        //放行操作
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Demo 放行后的逻辑");
    }

    //只调用一次
    @Override
    public void destroy() {
        System.out.println("destroy方法执行");
        //Filter.super.destroy();
    }
}
