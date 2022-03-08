package com.zkdlu.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static com.zkdlu.auth.OAuth2AuthorizationRequestBasedOnCookieRepository.AUTH_TOKEN;
import static com.zkdlu.auth.OAuth2AuthorizationRequestBasedOnCookieRepository.REDIRECT_URI_PARAM_COOKIE_NAME;
import static com.zkdlu.auth.OAuth2AuthorizationRequestBasedOnCookieRepository.REFRESH_TOKEN;

@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final CustomTokenService tokenService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Optional<String> redirectUri = CookieUtil.getCookie(request, REDIRECT_URI_PARAM_COOKIE_NAME)
                .map(Cookie::getValue);

        String targetUrl = redirectUri.get();

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        CustomOAuth2User customOAuth2User = CustomOAuth2User.mapFrom(oAuth2User);
        CustomToken token = tokenService.allocateToken(customOAuth2User);

        CookieUtil.deleteCookie(request, response, REFRESH_TOKEN);
        CookieUtil.addCookie(response, AUTH_TOKEN, token.getAuth(), -1);
        CookieUtil.addCookie(response, REFRESH_TOKEN, token.getRefresh(), -1);

        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}
