package com.zkdlu.auth;

import lombok.Getter;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Getter
public class CustomOAuth2User {
    private String email;
    private String name;
    private String thumbnail;

    private CustomOAuth2User(String email, String name, String thumbnail) {
        this.email = email;
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public static CustomOAuth2User mapFrom(OAuth2User oAuth2User) {
        var attributes = oAuth2User.getAttributes();

        return new CustomOAuth2User(
                (String)attributes.get("email"),
                (String)attributes.get("name"),
                (String)attributes.get("thumbnail"));
    }
}
