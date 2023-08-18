package org.keran.domain.ports.spi.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;

import java.util.UUID;

public interface LoyaltyCustomerFindPersistencePort {
    LoyaltyCustomerDto findLoyaltyCustomerById(UUID id);
    LoyaltyCustomerDto findLoyaltyCustomerByCustomerNumber(String customerNumber);
}
