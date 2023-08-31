package org.keran.domain.service.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.ports.api.loyaltyCustomer.LoyaltyCustomerAddServicePort;
import org.keran.domain.ports.spi.loyaltyCustomer.LoyaltyCustomerAddPersistencePort;
import org.keran.domain.validator.loyaltyCustomer.LoyaltyCustomerValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyCustomerAddService implements LoyaltyCustomerAddServicePort {
    private final LoyaltyCustomerAddPersistencePort loyaltyCustomerAddPersistencePort;
    private final LoyaltyCustomerValidator loyaltyCustomerValidator;

    public LoyaltyCustomerAddService(LoyaltyCustomerAddPersistencePort loyaltyCustomerAddPersistencePort, LoyaltyCustomerValidator loyaltyCustomerValidator) {
        this.loyaltyCustomerAddPersistencePort = loyaltyCustomerAddPersistencePort;
        this.loyaltyCustomerValidator = loyaltyCustomerValidator;
    }

    @Override
    public Optional<LoyaltyCustomerDto> addLoyaltyCustomer(LoyaltyCustomerDto loyaltyCustomerDto) {
        // Business validation:
        // - if ID is provided, it must be unique:
        if (loyaltyCustomerDto.getId() != null) {
            loyaltyCustomerValidator.validateLoyaltyCustomerNotExists(loyaltyCustomerDto.getId());
        }
        // - customer number must be unique:
        loyaltyCustomerValidator.validateLoyaltyCustomerNumberNotExists(loyaltyCustomerDto.getCustomerNumber());

        return loyaltyCustomerAddPersistencePort.addLoyaltyCustomer(loyaltyCustomerDto);
    }
}
