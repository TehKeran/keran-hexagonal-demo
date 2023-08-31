package org.keran.domain.service.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.domain.ports.api.loyaltyEventOccurrence.LoyaltyEventOccurrenceUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyEventOccurrence.LoyaltyEventOccurrenceUpdatePersistencePort;
import org.keran.domain.validator.loyaltyEventOccurrence.LoyaltyEventOccurrenceValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyEventOccurrenceUpdateService implements LoyaltyEventOccurrenceUpdateServicePort {
    private final LoyaltyEventOccurrenceUpdatePersistencePort loyaltyEventOccurrenceUpdatePersistencePort;
    private final LoyaltyEventOccurrenceValidator loyaltyEventOccurrenceValidator;

    public LoyaltyEventOccurrenceUpdateService(LoyaltyEventOccurrenceUpdatePersistencePort loyaltyEventOccurrenceUpdatePersistencePort, LoyaltyEventOccurrenceValidator loyaltyEventOccurrenceValidator) {
        this.loyaltyEventOccurrenceUpdatePersistencePort = loyaltyEventOccurrenceUpdatePersistencePort;
        this.loyaltyEventOccurrenceValidator = loyaltyEventOccurrenceValidator;
    }

    @Override
    public Optional<LoyaltyEventOccurrenceDto> updateLoyaltyEventOccurrence(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto) {
        // Business validation
        // - Entity must exist
        loyaltyEventOccurrenceValidator.validateLoyaltyEventOccurrenceExists(loyaltyEventOccurrenceDto.getId());

        return loyaltyEventOccurrenceUpdatePersistencePort.updateLoyaltyEventOccurrence(loyaltyEventOccurrenceDto);
    }
}
