package org.keran.domain.ports.api.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;

import java.util.Optional;
import java.util.UUID;

public interface LoyaltyCustomerFindServicePort {
    Optional<LoyaltyCustomerDto> findLoyaltyCustomerById(UUID id);
    Optional<LoyaltyCustomerDto> findLoyaltyCustomerByCustomerNumber(String customerNumber);
}
