package io.github.wotjd243.ecommerce.user.domain;

import io.github.wotjd243.ecommerce.user.application.dto.UserResponseDto;

import java.util.Collections;

public class User {
    private Long id;
    private final String userId;
    private String address;

    private ShippingAddresses shippingAddresses;

    private ShoppingBasket shoppingBasket;

    public User(String userId, String address) {
        this.userId = userId;
        this.address = address;
        this.shippingAddresses = new ShippingAddresses(Collections.emptySet());
    }

    public UserResponseDto toDto() {
        return new UserResponseDto(userId);
    }

    public boolean match(String userId) {
        return this.userId == userId;
    }

    public ShippingAddress addShippingAddress(String address, String zipCode) {
        return shippingAddresses.add(new ShippingAddress(address, zipCode));
    }

    public ConsideringItem addConsideringItem(ConsideringItem consideringItem) {
        return shoppingBasket.addConsideringItem(consideringItem);
    }

    public boolean removeConsideringItem(ConsideringItem consideringItem) {
        return shoppingBasket.removeConsideringItem(consideringItem);
    }
}
