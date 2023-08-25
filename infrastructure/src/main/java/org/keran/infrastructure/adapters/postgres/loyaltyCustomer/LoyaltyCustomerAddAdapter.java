package org.keran.infrastructure.adapters.postgres.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.ports.spi.loyaltyCustomer.LoyaltyCustomerAddPersistencePort;
import org.springframework.stereotype.Service;

@Service

public class LoyaltyCustomerAddAdapter implements LoyaltyCustomerAddPersistencePort {
    @Override
    public LoyaltyCustomerDto addLoyaltyCustomer(LoyaltyCustomerDto loyaltyCustomerDto) {
        return null;
    }
}
