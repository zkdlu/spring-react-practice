package com.zkdlu.market;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class MarketServiceTest {

    private ProductRepository spyProductRepository;
    private MarketService marketService;

    @BeforeEach
    void setUp() {
        spyProductRepository = mock(ProductRepository.class);
        marketService = new MarketService(spyProductRepository);
    }

    @Test
    void getProducts_returnsProducts() {
        List<Product> expected = List.of(new Product(1L, "name", 1, 1));
        given(spyProductRepository.findAll()).willReturn(expected);

        List<Product> actual = marketService.getProducts();

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}