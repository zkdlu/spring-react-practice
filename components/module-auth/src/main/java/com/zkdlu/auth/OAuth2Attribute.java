package com.zkdlu.auth;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class OAuth2Attribute {
    private String email;
    private String name;
    private String thumbnail;

    @Builder
    private OAuth2Attribute(String email, String name, String thumbnail) {
        this.email = email;
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public static OAuth2Attribute of(String registrationId, String attributeKey, Map<String, Object> attributes) {
        if ("kakao".equals(registrationId)) {
            return ofKakao(attributes);
        }

        throw new IllegalStateException();
    }

    private static OAuth2Attribute ofKakao(Map<String, Object> attributes) {
        var kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        var kakaoProfile = (Map<String, Object>) kakaoAccount.get("profile");

        return OAuth2Attribute.builder()
                .name((String) kakaoProfile.get("nickname"))
                .email((String) kakaoAccount.get("email"))
                .thumbnail((String) kakaoProfile.get("profile_image_url"))
                .build();
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("email", email);
        map.put("thumbnail", thumbnail);

        return map;
    }
}
