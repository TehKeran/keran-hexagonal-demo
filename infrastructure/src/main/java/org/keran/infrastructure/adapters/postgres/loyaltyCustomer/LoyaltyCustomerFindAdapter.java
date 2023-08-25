package org.keran.infrastructure.adapters.postgres.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.ports.spi.loyaltyCustomer.LoyaltyCustomerFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class LoyaltyCustomerFindAdapter implements LoyaltyCustomerFindPersistencePort {
    @Override
    public LoyaltyCustomerDto findLoyaltyCustomerById(UUID id) {
        return null;
    }

    @Override
    public LoyaltyCustomerDto findLoyaltyCustomerByCustomerNumber(String customerNumber) {
        return null;
    }
}
