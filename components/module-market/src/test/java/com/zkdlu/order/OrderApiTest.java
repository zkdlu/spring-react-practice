package com.zkdlu.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OrderApiTest {

    private MockMvc mockMvc;
    private OrderService spyOrderSerivce;

    @BeforeEach
    void setUp() {
        spyOrderSerivce = mock(OrderService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new OrderApi(spyOrderSerivce)).build();
    }

    @Test
    void placeOrder_returnsCreatedHttpStatus() throws Exception {
        mockMvc.perform(post("/order/1"))
                .andExpect(status().isCreated());
    }

    @Test
    void placeOrder_returnsOrderResponse() throws Exception {
        given(spyOrderSerivce.placeOrder(any())).willReturn(new OrderResponse("", 1L));

        mockMvc.perform(post("/order/1"))
                .andExpect(jsonPath("$.orderId", equalTo("")))
                .andExpect(jsonPath("$.productNo", equalTo(1)))
        ;
    }

    @Test
    void placeOrder_passesProductIdToService() throws Exception {
        mockMvc.perform(post("/order/1"));

        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);

        verify(spyOrderSerivce, times(1)).placeOrder(longArgumentCaptor.capture());
        assertThat(longArgumentCaptor.getValue()).isEqualTo(1L);
    }
}