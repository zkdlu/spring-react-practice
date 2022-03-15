package com.zkdlu.market;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarketApi {

    @GetMapping("products")
    public List<Product> getProducts() {
        Product product = new Product(1, "name", 1, 1);
        return List.of(
                product
        );
    }
}
