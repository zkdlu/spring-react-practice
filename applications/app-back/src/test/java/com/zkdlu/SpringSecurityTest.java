package com.zkdlu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringSecurityTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void 미인증시_403() throws Exception {
        mockMvc.perform(get("/test").with(anonymous()))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    void 인증시_200() throws Exception {
        mockMvc.perform(get("/test").with(user("zkdlu").roles("USER")))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
