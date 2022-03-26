package com.zkdlu.order;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderitem_id")
    private OrderItem orderItem;
    @Enumerated(EnumType.STRING)
    private OrderState state;

    @Builder
    public Order(Long id, OrderItem orderItem, OrderState state) {
        this.id = id;
        this.orderItem = orderItem;
        this.state = state;
    }

    public enum OrderState {
        ORDERED, PAYED, COMPLETE
    }
}
