package com.zkdlu.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderResponse {
    private final Long orderId;
    private final Long productNo;
}
