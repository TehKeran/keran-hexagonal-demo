package org.keran.domain.ports.spi.loyaltyCustomer;

import java.util.UUID;

public interface LoyaltyCustomerDeletePersistencePort {
    void deleteLoyaltyCustomerById(UUID id);
    void deleteLoyaltyCustomerByCustomerNumber(String customerNumber);
}
