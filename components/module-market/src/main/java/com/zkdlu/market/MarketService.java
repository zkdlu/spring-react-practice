package com.zkdlu.market;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {
    private final ProductRepository productRepository;

    public MarketService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }
}
