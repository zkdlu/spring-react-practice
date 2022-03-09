package com.zkdlu.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TodoApiTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new TodoApi()).build();
    }

    @Test
    void getTodos_returnsOkHttpStatus() throws Exception {
        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk());
    }

    @Test
    void getTodos_returnsTodos() throws Exception {
        mockMvc.perform(get("/todos"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].content", equalTo("content")))
                .andExpect(jsonPath("$[0].complete", equalTo(true)))
                ;
    }
}