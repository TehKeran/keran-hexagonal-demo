package org.keran.domain.ports.spi.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;

import java.util.Optional;
import java.util.UUID;

public interface LoyaltyCustomerFindPersistencePort {
    Optional<LoyaltyCustomerDto> findLoyaltyCustomerById(UUID id);
    Optional<LoyaltyCustomerDto> findLoyaltyCustomerByCustomerNumber(String customerNumber);
    Boolean existsById(UUID id);
    Boolean existsByCustomerNumber(String customerNumber);

}
