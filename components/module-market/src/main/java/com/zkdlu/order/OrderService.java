package com.zkdlu.order;

import com.zkdlu.market.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final ProductClient productClient;
    private final OrderRepository orderRepository;

    public OrderResponse placeOrder(Long productId) {
        Product product = productClient.getProduct(productId);

        Order savedOrder = orderRepository.save(getOrder(product));

        return new OrderResponse(savedOrder.getId(), productId);
    }

    private Order getOrder(Product product) {
        return Order.builder()
                .orderItem(new OrderItem(product))
                .state(Order.OrderState.ORDERED)
                .build();
    }
}
