package org.keran.domain.service.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.ports.api.loyaltyCustomer.LoyaltyCustomerUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyCustomer.LoyaltyCustomerUpdatePersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyCustomerUpdateService implements LoyaltyCustomerUpdateServicePort {
    private final LoyaltyCustomerUpdatePersistencePort loyaltyCustomerUpdatePersistencePort;

    public LoyaltyCustomerUpdateService(LoyaltyCustomerUpdatePersistencePort loyaltyCustomerUpdatePersistencePort) {
        this.loyaltyCustomerUpdatePersistencePort = loyaltyCustomerUpdatePersistencePort;
    }

    @Override
    public Optional<LoyaltyCustomerDto> updateLoyaltyCustomer(LoyaltyCustomerDto loyaltyCustomerDto) {
        return loyaltyCustomerUpdatePersistencePort.updateLoyaltyCustomer(loyaltyCustomerDto);
    }
}
