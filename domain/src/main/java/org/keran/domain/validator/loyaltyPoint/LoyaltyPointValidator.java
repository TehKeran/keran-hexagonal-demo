package org.keran.domain.validator.loyaltyPoint;

import org.keran.domain.exception.common.EntityAlreadyExistsException;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyPoint.LoyaltyPointFindServicePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyPointValidator {
    private final String entityName = "LoyaltyPoint";
    private final LoyaltyPointFindServicePort loyaltyPointFindServicePort;

    public LoyaltyPointValidator(LoyaltyPointFindServicePort loyaltyPointFindServicePort) {
        this.loyaltyPointFindServicePort = loyaltyPointFindServicePort;
    }

    /**
     * Validates if loyalty event Occurrence exists
     * Throws {@link EntityNotFoundException} if not exists
     * @param id Loyalty Event Occurrence ID
     */
    public void validateLoyaltyPointExists(UUID id) {
        boolean loyaltyPointExists = loyaltyPointFindServicePort.existsById(id);

        if (!loyaltyPointExists) {
            throw new EntityNotFoundException(entityName, id.toString());
        }
    }

    /**
     * Validates if loyalty event Occurrence doesn't already exist
     * Throws {@link EntityAlreadyExistsException} if already exists
     * @param id Loyalty Event Occurrence ID
     */
    public void validateLoyaltyPointNotExists(UUID id) {
        boolean loyaltyPointExists = loyaltyPointFindServicePort.existsById(id);

        if (loyaltyPointExists) {
            throw new EntityAlreadyExistsException(entityName, id.toString());
        }
    }
    
}
