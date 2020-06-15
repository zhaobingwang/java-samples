package com.example.demo.filter;

import com.example.demo.constants.FilterConst;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@Component  // 这个注解的目的是将myCustomFilter交给容器来处理。也就是让myCustomFilter起作用
// 以下配置导致过滤器执行两次??
@WebFilter(urlPatterns = FilterConst.MyCustomFilter.URL_PATTERNS,
        filterName = FilterConst.MyCustomFilter.NAME)   // 是用来配置针对于什么链接做过滤，filter的名称是什么
@Order(FilterConst.MyCustomFilter.ORDER)   // 用来定义过滤器的执行顺序，多个过滤器的情况下，值越小，过滤器越先被执行
public class MyCustomFilter implements Filter {
    private static final String filterName = FilterConst.MyCustomFilter.NAME;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterName + " init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println(filterName + " start...");

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        System.out.println("Request url is " + request.getRequestURL());
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println(filterName + " finish...");
    }

    @Override
    public void destroy() {
        System.out.println(filterName + "  destroy...");
    }
}
