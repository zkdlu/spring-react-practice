package com.zkdlu.market;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarketApi {
    private final MarketService marketService;

    public MarketApi(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("products")
    public List<Product> getProducts() {
        return marketService.getProducts();
    }

    @GetMapping("products/{id}")
    public Product getProduct(@PathVariable Long id) {
        return marketService.getProduct(id);
    }
}
