package org.keran.domain.service.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.domain.ports.api.loyaltyEventOccurrence.LoyaltyEventOccurrenceAddServicePort;
import org.keran.domain.ports.spi.loyaltyEventOccurrence.LoyaltyEventOccurrenceAddPersistencePort;
import org.keran.domain.validator.loyaltyCustomer.LoyaltyCustomerValidator;
import org.keran.domain.validator.loyaltyEvent.LoyaltyEventValidator;
import org.keran.domain.validator.loyaltyEventOccurrence.LoyaltyEventOccurrenceValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyEventOccurrenceAddService implements LoyaltyEventOccurrenceAddServicePort {
    private final LoyaltyEventOccurrenceAddPersistencePort loyaltyEventOccurrenceAddPersistencePort;
    private final LoyaltyEventValidator loyaltyEventValidator;
    private final LoyaltyCustomerValidator loyaltyCustomerValidator;
    private final LoyaltyEventOccurrenceValidator loyaltyEventOccurrenceValidator;

    public LoyaltyEventOccurrenceAddService(LoyaltyEventOccurrenceAddPersistencePort loyaltyEventOccurrenceAddPersistencePort, LoyaltyEventValidator loyaltyEventValidator, LoyaltyCustomerValidator loyaltyCustomerValidator, LoyaltyEventOccurrenceValidator loyaltyEventOccurrenceValidator) {
        this.loyaltyEventOccurrenceAddPersistencePort = loyaltyEventOccurrenceAddPersistencePort;
        this.loyaltyEventValidator = loyaltyEventValidator;
        this.loyaltyCustomerValidator = loyaltyCustomerValidator;
        this.loyaltyEventOccurrenceValidator = loyaltyEventOccurrenceValidator;
    }

    @Override
    public Optional<LoyaltyEventOccurrenceDto> addLoyaltyEventOccurrence(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto) {
        // Business validation
        // - If ID is provided - Entity must not exist already
        if (loyaltyEventOccurrenceDto.getId() != null) {
            loyaltyEventOccurrenceValidator.validateLoyaltyEventOccurrenceNotExists(loyaltyEventOccurrenceDto.getId());
        }
        // - Loyalty customer must exist:
        loyaltyCustomerValidator.validateLoyaltyCustomerExists(loyaltyEventOccurrenceDto.getLoyaltyCustomerDto().getId());
        // - Loyalty event must exist:
        loyaltyEventValidator.validateLoyaltyEventExists(loyaltyEventOccurrenceDto.getLoyaltyEventDto().getId());
        return loyaltyEventOccurrenceAddPersistencePort.addLoyaltyEventOccurrence(loyaltyEventOccurrenceDto);
    }
}
