package com.zkdlu.order;

import com.zkdlu.market.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@NoArgsConstructor
@Entity
public class OrderItem {
    @Id @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    OrderItem(Long id, Product product) {
        this.id = id;
        this.product = product;
    }

    public OrderItem(Product product) {
        this(null, product);
    }
}
