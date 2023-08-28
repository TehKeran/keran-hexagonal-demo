package org.keran.domain.service.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.ports.api.loyaltyCustomer.LoyaltyCustomerFindServicePort;
import org.keran.domain.ports.spi.loyaltyCustomer.LoyaltyCustomerFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class LoyaltyCustomerFindService implements LoyaltyCustomerFindServicePort {
    private final LoyaltyCustomerFindPersistencePort loyaltyCustomerFindPersistencePort;

    public LoyaltyCustomerFindService(LoyaltyCustomerFindPersistencePort loyaltyCustomerFindPersistencePort) {
        this.loyaltyCustomerFindPersistencePort = loyaltyCustomerFindPersistencePort;
    }

    @Override
    public Optional<LoyaltyCustomerDto> findLoyaltyCustomerById(UUID id) {
        return loyaltyCustomerFindPersistencePort.findLoyaltyCustomerById(id);
    }

    @Override
    public Optional<LoyaltyCustomerDto> findLoyaltyCustomerByCustomerNumber(String customerNumber) {
        return loyaltyCustomerFindPersistencePort.findLoyaltyCustomerByCustomerNumber(customerNumber);
    }

    @Override
    public Boolean existsById(UUID id) {
        return loyaltyCustomerFindPersistencePort.existsById(id);
    }

    @Override
    public Boolean existsByCustomerNumber(String customerNumber) {
        return loyaltyCustomerFindPersistencePort.existsByCustomerNumber(customerNumber);
    }
}
