package com.zkdlu.market;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
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

    @Test
    void getProduct_returnsProduct() {
        Product givenProduct = new Product(1L, "name1", 1, 1);
        given(spyProductRepository.findById(any())).willReturn(Optional.ofNullable(givenProduct));

        Product actual = marketService.getProduct(1L);

        assertThat(actual).isEqualTo(givenProduct);
    }

    @Test
    void getProduct_throwsNotFoundProductException() {
        Assertions.assertThrows(ProductNotFoundException.class, () -> {
            marketService.getProduct(1L);
        });
    }
}