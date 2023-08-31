package org.keran.domain.service.loyaltyEventOccurrence;

import org.keran.domain.ports.api.loyaltyEventOccurrence.LoyaltyEventOccurrenceDeleteServicePort;
import org.keran.domain.ports.spi.loyaltyEventOccurrence.LoyaltyEventOccurrenceDeletePersistencePort;
import org.keran.domain.validator.loyaltyEventOccurrence.LoyaltyEventOccurrenceValidator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyEventOccurrenceDeleteService implements LoyaltyEventOccurrenceDeleteServicePort {
    private final LoyaltyEventOccurrenceDeletePersistencePort loyaltyEventOccurrenceDeletePersistencePort;
    private final LoyaltyEventOccurrenceValidator loyaltyEventOccurrenceValidator;


    public LoyaltyEventOccurrenceDeleteService(LoyaltyEventOccurrenceDeletePersistencePort loyaltyEventOccurrenceDeletePersistencePort, LoyaltyEventOccurrenceValidator loyaltyEventOccurrenceValidator) {
        this.loyaltyEventOccurrenceDeletePersistencePort = loyaltyEventOccurrenceDeletePersistencePort;
        this.loyaltyEventOccurrenceValidator = loyaltyEventOccurrenceValidator;
    }

    @Override
    public void deleteLoyaltyEventOccurrenceById(UUID id) {
        // Domain validation
        // - Entity must exist
        loyaltyEventOccurrenceValidator.validateLoyaltyEventOccurrenceExists(id);

        loyaltyEventOccurrenceDeletePersistencePort.deleteLoyaltyEventOccurrenceById(id);
    }

    @Override
    public void deleteAllLoyaltyEventOccurrencesByLoyaltyCustomerId(UUID loyaltyCustomerId) {
        loyaltyEventOccurrenceDeletePersistencePort.deleteAllLoyaltyEventOccurrencesByLoyaltyCustomerId(loyaltyCustomerId);
    }

    @Override
    public void deleteAllLoyaltyEventOccurrencesByLoyaltyEventId(UUID loyaltyEventId) {
        loyaltyEventOccurrenceDeletePersistencePort.deleteAllLoyaltyEventOccurrencesByLoyaltyEventId(loyaltyEventId);
    }
}
