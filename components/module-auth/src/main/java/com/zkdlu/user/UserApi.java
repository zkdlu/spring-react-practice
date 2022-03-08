package com.zkdlu.user;

import com.zkdlu.auth.CustomTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserApi {
    private final CustomTokenService tokenService;

    @GetMapping("/me")
    public User getMySelf(@CookieValue(name = "auth_token") String authToken) {
        tokenService.getEmail(authToken);
        return new User("zkdlu159951@gmail.com",
                "이건",
                "http://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg");
    }
}
