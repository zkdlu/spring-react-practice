package com.zkdlu.market;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarketInitializer implements ApplicationRunner {
    private final ProductRepository productRepository;

    public MarketInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            products.add(new Product((long) i, "name" + i, 1000, 10));
        }

        productRepository.saveAll(products);
    }
}
