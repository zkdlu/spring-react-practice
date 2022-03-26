package com.zkdlu.order;

import com.zkdlu.market.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {

    private OrderService orderService;
    private SpyProductClient spyProductClient;
    private SpyOrderRepository spyOrderRepository;

    @BeforeEach
    void setUp() {
        spyProductClient = new SpyProductClient();
        spyOrderRepository = new SpyOrderRepository();

        orderService = new OrderService(spyProductClient, spyOrderRepository);
    }

    @Test
    void placeOrder_passesProductIdToProductClient() {
        Long givenProductId = 1L;

        orderService.placeOrder(givenProductId);

        assertThat(spyProductClient.getProduct_argumentId).isEqualTo(givenProductId);
    }

    @Test
    void placeOrder_passesOrderToRepository() {
        Product givenProduct = new Product(1L, "name", 1000, 10);
        spyProductClient.getProduct_returnValue = givenProduct;

        orderService.placeOrder(null);

        Order result = spyOrderRepository.save_argumentOrder;
        assertThat(result.getState()).isEqualTo(Order.OrderState.ORDERED);
        assertThat(result.getOrderItem().getProduct().getId()).isEqualTo(1L);
        assertThat(result.getOrderItem().getProduct().getName()).isEqualTo("name");
        assertThat(result.getOrderItem().getProduct().getPrice()).isEqualTo(1000);
        assertThat(result.getOrderItem().getProduct().getStock()).isEqualTo(10);
    }

    @Test
    void placeOrder_returnsOrderResponse() {
        Order givenOrder = Order.builder()
                .id(1L)
                .build();
        spyOrderRepository.save_returnValue = givenOrder;

        OrderResponse result = orderService.placeOrder(1L);

        assertThat(result.getOrderId()).isEqualTo(givenOrder.getId());
        assertThat(result.getProductNo()).isEqualTo(1L);
    }
}