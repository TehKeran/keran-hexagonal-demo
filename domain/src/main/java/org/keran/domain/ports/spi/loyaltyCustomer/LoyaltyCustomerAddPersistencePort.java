package org.keran.domain.ports.spi.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;

import java.util.Optional;

public interface LoyaltyCustomerAddPersistencePort {
    Optional<LoyaltyCustomerDto> addLoyaltyCustomer(LoyaltyCustomerDto loyaltyCustomerDto);

}
