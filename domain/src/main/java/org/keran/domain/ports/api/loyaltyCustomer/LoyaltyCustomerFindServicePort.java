package org.keran.domain.ports.api.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;

import java.util.UUID;

public interface LoyaltyCustomerFindServicePort {
    LoyaltyCustomerDto findLoyaltyCustomerById(UUID id);
    LoyaltyCustomerDto findLoyaltyCustomerByCustomerNumber(String customerNumber);
}
