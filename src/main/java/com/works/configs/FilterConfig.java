package com.works.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Configuration
public class FilterConfig implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        String detail = "" + auth.getDetails();
        String agent = req.getHeader("user-agent");
        Long date = new Date().getTime();
        System.out.println(url + " " + username + " " + detail + " " + agent + " " + date);
        auth.getAuthorities().toArray();

        filterChain.doFilter(req, res);


    }
}
