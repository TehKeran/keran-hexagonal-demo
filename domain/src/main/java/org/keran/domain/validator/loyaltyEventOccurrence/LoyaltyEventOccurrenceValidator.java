package org.keran.domain.validator.loyaltyEventOccurrence;

import org.keran.domain.exception.common.EntityAlreadyExistsException;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyEventOccurrence.LoyaltyEventOccurrenceFindServicePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyEventOccurrenceValidator {
    private final Object currentClass = LoyaltyEventOccurrenceValidator.class;
    private final String entityName = "LoyaltyEventOccurrence";
    private final LoyaltyEventOccurrenceFindServicePort loyaltyEventOccurrenceFindServicePort;

    public LoyaltyEventOccurrenceValidator(LoyaltyEventOccurrenceFindServicePort loyaltyEventOccurrenceFindServicePort) {
        this.loyaltyEventOccurrenceFindServicePort = loyaltyEventOccurrenceFindServicePort;
    }

    /**
     * Validates if loyalty event Occurrence exists
     * Throws {@link EntityNotFoundException} if not exists
     * @param id Loyalty Event Occurrence ID
     */
    public void validateLoyaltyEventOccurrenceExists(UUID id) {
        boolean loyaltyEventOccurrenceExists = loyaltyEventOccurrenceFindServicePort.existsById(id);

        if (!loyaltyEventOccurrenceExists) {
            throw new EntityNotFoundException(currentClass, entityName, id.toString());
        }
    }

    /**
     * Validates if loyalty event Occurrence doesn't already exist
     * Throws {@link EntityAlreadyExistsException} if already exists
     * @param id Loyalty Event Occurrence ID
     */
    public void validateLoyaltyEventOccurrenceNotExists(UUID id) {
        boolean loyaltyEventOccurrenceExists = loyaltyEventOccurrenceFindServicePort.existsById(id);

        if (loyaltyEventOccurrenceExists) {
            throw new EntityAlreadyExistsException(currentClass, entityName, id.toString());
        }
    }
}
