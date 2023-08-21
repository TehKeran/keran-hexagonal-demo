package org.keran.domain.service.loyaltyCustomer;

import org.keran.domain.ports.api.loyaltyCustomer.LoyaltyCustomerDeleteServicePort;
import org.keran.domain.ports.spi.loyaltyCustomer.LoyaltyCustomerDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyCustomerDeleteService implements LoyaltyCustomerDeleteServicePort {
    private final LoyaltyCustomerDeletePersistencePort loyaltyCustomerDeletePersistencePort;

    public LoyaltyCustomerDeleteService(LoyaltyCustomerDeletePersistencePort loyaltyCustomerDeletePersistencePort) {
        this.loyaltyCustomerDeletePersistencePort = loyaltyCustomerDeletePersistencePort;
    }

    @Override
    public void deleteLoyaltyCustomerById(UUID id) {
        loyaltyCustomerDeletePersistencePort.deleteLoyaltyCustomerById(id);
    }

    @Override
    public void deleteLoyaltyCustomerByCustomerNumber(String customerNumber) {
        loyaltyCustomerDeletePersistencePort.deleteLoyaltyCustomerByCustomerNumber(customerNumber);
    }
}
