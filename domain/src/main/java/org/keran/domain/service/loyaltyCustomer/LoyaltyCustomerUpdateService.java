package org.keran.domain.service.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.ports.api.loyaltyCustomer.LoyaltyCustomerUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyCustomer.LoyaltyCustomerUpdatePersistencePort;
import org.keran.domain.validator.loyaltyCustomer.LoyaltyCustomerValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyCustomerUpdateService implements LoyaltyCustomerUpdateServicePort {
    private final LoyaltyCustomerUpdatePersistencePort loyaltyCustomerUpdatePersistencePort;
    private final LoyaltyCustomerValidator loyaltyCustomerValidator;

    public LoyaltyCustomerUpdateService(LoyaltyCustomerUpdatePersistencePort loyaltyCustomerUpdatePersistencePort, LoyaltyCustomerValidator loyaltyCustomerValidator) {
        this.loyaltyCustomerUpdatePersistencePort = loyaltyCustomerUpdatePersistencePort;
        this.loyaltyCustomerValidator = loyaltyCustomerValidator;
    }

    @Override
    public Optional<LoyaltyCustomerDto> updateLoyaltyCustomer(LoyaltyCustomerDto loyaltyCustomerDto) {
        // Business validation
        // - loyalty customer must exist:
        loyaltyCustomerValidator.validateLoyaltyCustomerExists(loyaltyCustomerDto.getId());

        return loyaltyCustomerUpdatePersistencePort.updateLoyaltyCustomer(loyaltyCustomerDto);
    }
}
