package com.works.configs;

import com.works.entities.Info;
import com.works.repositories.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class FilterConfig implements Filter {

    final InfoRepository infoRepository;
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

        // bi kullanıcının yekisi olmadığı durumlarda atılan isteklerde isteğin önünü kesmek için kullanılır.
        List<String> roles = new ArrayList<>();
        for(GrantedAuthority item : auth.getAuthorities()){
            roles.add(item.getAuthority());
        }
        String sessionID = req.getSession().getId();

        System.out.println(url + " "+roles+"" + username + " " + detail + " " + agent + " " + date);
        if(!url.contains("h2-console")){
        Info i = new Info();
        i.setUrl(url);
        i.setRoles(roles.toString());
        i.setAgent(agent);
        i.setDate(date);
        i.setDetail(detail);
        i.setUsername(username);
        i.setSessionID(sessionID);

        infoRepository.save(i);
        }

        filterChain.doFilter(req, res);


    }
}
