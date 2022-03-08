package com.zkdlu.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static com.zkdlu.auth.OAuth2AuthorizationRequestBasedOnCookieRepository.AUTH_TOKEN;


@RequiredArgsConstructor
public class JwtAuthFilter extends GenericFilterBean {
    private final CustomTokenService tokenService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Cookie token = CookieUtil.getCookie((HttpServletRequest) request, AUTH_TOKEN)
                .orElse(null);

        if (null != token && tokenService.verifyToken(token.getValue())) {
            Authentication authentication = new UsernamePasswordAuthenticationToken("test", "", List.of(new SimpleGrantedAuthority("ROLE_USER")));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }
}
