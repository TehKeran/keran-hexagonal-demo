package org.keran.infrastructure.adapters.postgres.loyaltyCustomer;

import org.keran.domain.ports.spi.loyaltyCustomer.LoyaltyCustomerDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class LoyaltyCustomerDeleteAdapter implements LoyaltyCustomerDeletePersistencePort {
    @Override
    public void deleteLoyaltyCustomerById(UUID id) {

    }

    @Override
    public void deleteLoyaltyCustomerByCustomerNumber(String customerNumber) {

    }
}
