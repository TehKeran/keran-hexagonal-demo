package org.keran.domain.validator.loyaltyProgram;

import org.keran.domain.exception.common.EntityAlreadyExistsException;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyProgram.LoyaltyProgramFindServicePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyProgramValidator {
    private final Object currentClass = LoyaltyProgramValidator.class;
    private final String entityName = "LoyaltyProgram";

    private final LoyaltyProgramFindServicePort loyaltyProgramFindServicePort;

    public LoyaltyProgramValidator(LoyaltyProgramFindServicePort loyaltyProgramFindServicePort) {
        this.loyaltyProgramFindServicePort = loyaltyProgramFindServicePort;
    }

    /**
     * Validates if loyalty program exists
     * Throws {@link EntityNotFoundException} if it does not exist
     * @param id Loyalty program ID
     */
    public void validateLoyaltyProgramExists(UUID id) {
        boolean loyaltyProgramExists = loyaltyProgramFindServicePort.existsById(id);

        if (!loyaltyProgramExists) {
            throw new EntityNotFoundException(currentClass, entityName, id.toString());
        }
    }

    /**
     * Validates if loyalty program doesn't already exist
     * Throws {@link EntityAlreadyExistsException} if already exists
     * @param id Loyalty program ID
     */
    public void validateLoyaltyProgramNotExists(UUID id) {
        boolean loyaltyProgramExists = loyaltyProgramFindServicePort.existsById(id);

        if (loyaltyProgramExists) {
            throw new EntityAlreadyExistsException(currentClass, entityName, id.toString());
        }
    }
}
