package org.keran.domain.validator.loyaltyEvent;

import org.keran.domain.exception.common.EntityAlreadyExistsException;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventFindServicePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyEventValidator {
    private final Object currentClass = LoyaltyEventValidator.class;
    private final String entityName = "LoyaltyEvent";

    private final LoyaltyEventFindServicePort loyaltyEventFindServicePort;

    public LoyaltyEventValidator(LoyaltyEventFindServicePort loyaltyEventFindServicePort) {
        this.loyaltyEventFindServicePort = loyaltyEventFindServicePort;
    }

    /**
     * Validates if loyalty event exists
     * Throws {@link EntityNotFoundException} if not exists
     * @param id Loyalty Event ID
     */
    public void validateLoyaltyEventExists(UUID id) {
        boolean loyaltyEventExists = loyaltyEventFindServicePort.existsById(id);

        if (!loyaltyEventExists) {
            throw new EntityNotFoundException(currentClass, entityName, id.toString());
        }
    }

    /**
     * Validates if loyalty event does not already exist
     * Throws {@link EntityNotFoundException} if already exists
     * @param id Loyalty Event ID
     */
    public void validateLoyaltyEventNotExists(UUID id) {
        boolean loyaltyEventExists = loyaltyEventFindServicePort.existsById(id);

        if (loyaltyEventExists) {
            throw new EntityAlreadyExistsException(currentClass, entityName, id.toString());
        }
    }

    /**
     * Validates if loyalty event does not already exist by name
     * Throws {@link EntityNotFoundException} if already exists
     * @param name Loyalty Event name
     */
    public void validateLoyaltyEventNotExistsByName(String name) {
        boolean loyaltyEventExists = loyaltyEventFindServicePort.existsByName(name);

        if (loyaltyEventExists) {
            throw new EntityAlreadyExistsException(currentClass, entityName, name);
        }
    }
}
