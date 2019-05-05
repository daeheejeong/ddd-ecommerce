package io.github.wotjd243.ecommerce.user.infra;

import io.github.wotjd243.ecommerce.user.domain.ShippingAddress;

import java.util.List;

public interface ShippingAddressRepository {
    void save(ShippingAddress shippingAddress);

    List<ShippingAddress> findAllByUserId(String userId);
}