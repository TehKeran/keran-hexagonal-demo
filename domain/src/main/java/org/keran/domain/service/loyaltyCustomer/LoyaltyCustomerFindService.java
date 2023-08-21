package org.keran.domain.service.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.ports.api.loyaltyCustomer.LoyaltyCustomerFindServicePort;
import org.keran.domain.ports.spi.loyaltyCustomer.LoyaltyCustomerFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyCustomerFindService implements LoyaltyCustomerFindServicePort {
    private final LoyaltyCustomerFindPersistencePort loyaltyCustomerFindPersistencePort;

    public LoyaltyCustomerFindService(LoyaltyCustomerFindPersistencePort loyaltyCustomerFindPersistencePort) {
        this.loyaltyCustomerFindPersistencePort = loyaltyCustomerFindPersistencePort;
    }

    @Override
    public LoyaltyCustomerDto findLoyaltyCustomerById(UUID id) {
        return loyaltyCustomerFindPersistencePort.findLoyaltyCustomerById(id);
    }

    @Override
    public LoyaltyCustomerDto findLoyaltyCustomerByCustomerNumber(String customerNumber) {
        return loyaltyCustomerFindPersistencePort.findLoyaltyCustomerByCustomerNumber(customerNumber);
    }
}
