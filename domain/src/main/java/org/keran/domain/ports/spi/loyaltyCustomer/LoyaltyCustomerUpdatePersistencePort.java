package org.keran.domain.ports.spi.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;

public interface LoyaltyCustomerUpdatePersistencePort {
    LoyaltyCustomerDto updateLoyaltyCustomer(LoyaltyCustomerDto loyaltyCustomerDto);
}
