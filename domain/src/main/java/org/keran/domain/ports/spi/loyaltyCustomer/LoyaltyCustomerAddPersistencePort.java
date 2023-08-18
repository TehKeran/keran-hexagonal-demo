package org.keran.domain.ports.spi.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;

public interface LoyaltyCustomerAddPersistencePort {
    LoyaltyCustomerDto addLoyaltyCustomer(LoyaltyCustomerDto loyaltyCustomerDto);

}
