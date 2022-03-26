package com.zkdlu.order;

import com.zkdlu.market.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "product", url = "http://localhost:8080")
public interface ProductClient {
    @GetMapping("products/{id}")
    Product getProduct(@PathVariable(name = "id") Long id);
}
