package org.keran.domain.service.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.ports.api.loyaltyCustomer.LoyaltyCustomerAddServicePort;
import org.keran.domain.ports.spi.loyaltyCustomer.LoyaltyCustomerAddPersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyCustomerAddService implements LoyaltyCustomerAddServicePort {
    private final LoyaltyCustomerAddPersistencePort loyaltyCustomerAddPersistencePort;

    public LoyaltyCustomerAddService(LoyaltyCustomerAddPersistencePort loyaltyCustomerAddPersistencePort) {
        this.loyaltyCustomerAddPersistencePort = loyaltyCustomerAddPersistencePort;
    }

    @Override
    public Optional<LoyaltyCustomerDto> addLoyaltyCustomer(LoyaltyCustomerDto loyaltyCustomerDto) {
        return loyaltyCustomerAddPersistencePort.addLoyaltyCustomer(loyaltyCustomerDto);
    }
}
