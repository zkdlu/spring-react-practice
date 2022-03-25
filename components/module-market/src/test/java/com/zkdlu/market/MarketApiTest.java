package com.zkdlu.market;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MarketApiTest {

    private MockMvc mockMvc;
    private MarketService spyMarketService;

    @BeforeEach
    void setUp() {
        spyMarketService = mock(MarketService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new MarketApi(spyMarketService)).build();
    }

    @Test
    void getProducts_returnsOkHttpStatus() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk());
    }

    @Test
    void getProducts_returnsProducts() throws Exception {
        given(spyMarketService.getProducts()).willReturn(
                List.of((new Product(1L, "name1", 1, 1)))
        );

        mockMvc.perform(get("/products"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].name", equalTo("name1")))
                .andExpect(jsonPath("$[0].price", equalTo(1)))
                .andExpect(jsonPath("$[0].stock", equalTo(1)))
        ;
    }

    @Test
    void getProduct_returnsOkHttpStatus() throws Exception {
        mockMvc.perform(get("/products/1"))
                .andExpect(status().isOk());
    }

    @Test
    void getProduct_returnsProduct() throws Exception {
        given(spyMarketService.getProduct(any())).willReturn(new Product(1L, "name1", 1, 1));

        mockMvc.perform(get("/products/1"))
                .andExpect(jsonPath("$.id", equalTo(1)))
                .andExpect(jsonPath("$.name", equalTo("name1")))
                .andExpect(jsonPath("$.price", equalTo(1)))
                .andExpect(jsonPath("$.stock", equalTo(1)));
    }

    @Test
    void getProduct_passesIdToService() throws Exception {
        mockMvc.perform(get("/products/1"));

        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(spyMarketService, times(1)).getProduct(longArgumentCaptor.capture());
    }
}