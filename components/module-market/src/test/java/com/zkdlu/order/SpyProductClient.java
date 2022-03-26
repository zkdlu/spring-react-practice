package com.zkdlu.order;

import com.zkdlu.market.Product;

public class SpyProductClient implements ProductClient {
    public Long getProduct_argumentId;
    public Product getProduct_returnValue;

    @Override
    public Product getProduct(Long productId) {
        getProduct_argumentId = productId;
        return getProduct_returnValue;
    }
}
