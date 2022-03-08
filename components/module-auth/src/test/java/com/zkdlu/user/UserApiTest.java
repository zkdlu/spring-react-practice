package com.zkdlu.user;

import com.zkdlu.auth.CustomTokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.Cookie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserApiTest {

    private MockMvc mockMvc;
    private SpyTokenService spyTokenService;

    @BeforeEach
    void setUp() {
        spyTokenService = new SpyTokenService();
        mockMvc = MockMvcBuilders.standaloneSetup(new UserApi(spyTokenService)).build();
    }

    @Test
    void getMySelf_returnsOkHttpStatus() throws Exception {
        mockMvc.perform(get("/users/me").cookie(new Cookie("auth_token", "auth value")))
                .andExpect(status().isOk());
    }

    @Test
    void getMySelf_returnsUser() throws Exception {
        mockMvc.perform(get("/users/me").cookie(new Cookie("auth_token", "auth value")))
                .andExpect(jsonPath("$.email", equalTo("zkdlu159951@gmail.com")))
                .andExpect(jsonPath("$.name", equalTo("이건")))
                .andExpect(jsonPath("$.thumbnail", equalTo("http://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg")));
    }

    @Test
    void getMySelf_passesToTokenService() throws Exception {
        mockMvc.perform(get("/users/me").cookie(new Cookie("auth_token", "auth value")));

        assertThat(spyTokenService.getEmail_argumentToken).isEqualTo("auth value");
    }

    private static class SpyTokenService extends CustomTokenService {
        public String getEmail_argumentToken;

        @Override
        public String getEmail(String token) {
            getEmail_argumentToken = token;
            return null;
        }
    }
}