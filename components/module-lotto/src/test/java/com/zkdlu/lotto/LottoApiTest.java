package com.zkdlu.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LottoApiTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new LottoApi(new LottoGame())).build();
    }

    @Test
    void getRandom_returnsOkHttpStatus() throws Exception {
        mockMvc.perform(get("/lotto"))
                .andExpect(status().isOk());
    }

    @Test
    void getRandom_returnsLotto() throws Exception {
        mockMvc.perform(get("/lotto"))
                .andExpect(jsonPath("$.lottoNumbers").isArray())
                .andExpect(jsonPath("$.lottoNumbers", hasSize(6)))
        ;
    }
}