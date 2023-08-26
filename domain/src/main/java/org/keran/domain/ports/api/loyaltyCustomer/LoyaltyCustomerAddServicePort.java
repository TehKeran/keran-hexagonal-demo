package org.keran.domain.ports.api.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;

import java.util.Optional;

public interface LoyaltyCustomerAddServicePort {
    Optional<LoyaltyCustomerDto> addLoyaltyCustomer(LoyaltyCustomerDto loyaltyCustomerDto);

}
