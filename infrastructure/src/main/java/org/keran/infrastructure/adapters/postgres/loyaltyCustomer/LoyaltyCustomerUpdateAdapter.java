package org.keran.infrastructure.adapters.postgres.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.ports.spi.loyaltyCustomer.LoyaltyCustomerUpdatePersistencePort;
import org.springframework.stereotype.Service;

@Service

public class LoyaltyCustomerUpdateAdapter implements LoyaltyCustomerUpdatePersistencePort {
    @Override
    public LoyaltyCustomerDto updateLoyaltyCustomer(LoyaltyCustomerDto loyaltyCustomerDto) {
        return null;
    }
}
