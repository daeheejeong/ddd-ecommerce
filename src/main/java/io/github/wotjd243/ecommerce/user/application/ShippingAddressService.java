package io.github.wotjd243.ecommerce.user.application;

import io.github.wotjd243.ecommerce.user.application.dto.ShippingAddressDto;
import io.github.wotjd243.ecommerce.user.domain.ShippingAddress;
import io.github.wotjd243.ecommerce.user.domain.ZipCode;
import io.github.wotjd243.ecommerce.user.infra.ShippingAddressRepository;

public class ShippingAddressService {

    private ShippingAddressRepository shippingAddressRepository;

    public ShippingAddressService(ShippingAddressRepository shippingAddressRepository) {
        this.shippingAddressRepository = shippingAddressRepository;
    }

    public ShippingAddress addShippingAddress(ShippingAddressDto shippingAddressDto) {
        ShippingAddress shippingAddress = new ShippingAddress(
                shippingAddressDto.getAddress(),
                ZipCode.codeOf(shippingAddressDto.getZipCode())
        );
        return shippingAddressRepository.save(shippingAddress);
    }

    private boolean isShippingAddressExist(String userId, ShippingAddress shippingAddress) {
        return shippingAddressRepository.findAllByUserId(userId).contains(shippingAddress);
    }
}
