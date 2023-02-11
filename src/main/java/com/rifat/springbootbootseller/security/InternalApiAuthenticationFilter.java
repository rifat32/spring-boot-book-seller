package com.rifat.springbootbootseller.security;

import com.rifat.springbootbootseller.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class InternalApiAuthenticationFilter extends OncePerRequestFilter {

    private final String accessKey;

    public InternalApiAuthenticationFilter(String accessKey){
        this.accessKey = accessKey;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getRequestURI().startsWith("/api/internal");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    try {
        String requestKey = SecurityUtils.extractAuthTokenFromRequest(request);

        if(requestKey == null || !requestKey.equals(accessKey)){
            log.warn("internal key endpoint requested without/wrong key uri: {}",request.getRequestURI());
            throw new RuntimeException("UNAUTHORIZED");
        }
        UserPrincipal user = UserPrincipal.createSuperUser();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    catch (Exception ex){
log.error("could not set user authentication in security context",ex);
    }
    filterChain.doFilter(request,response);

    }



}

