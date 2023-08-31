package org.keran.domain.validator.loyaltyEventConfiguration;

import org.keran.domain.exception.common.EntityAlreadyExistsException;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventFindServicePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyEventConfigurationValidator {
    private final Object currentClass = LoyaltyEventConfigurationValidator.class;
    private final String entityName = "LoyaltyEventConfiguration";

    private final LoyaltyEventFindServicePort loyaltyEventFindServicePort;

    public LoyaltyEventConfigurationValidator(LoyaltyEventFindServicePort loyaltyEventFindServicePort) {
        this.loyaltyEventFindServicePort = loyaltyEventFindServicePort;
    }

    /**
     * Validates if loyalty event configuration exists
     * Throws {@link EntityNotFoundException} if not exists
     * @param id Loyalty Event Configuration ID
     */
    public void validateLoyaltyEventConfigurationExists(UUID id) {
        boolean loyaltyEventConfigurationExists = loyaltyEventFindServicePort.existsConfigurationById(id);

        if (!loyaltyEventConfigurationExists) {
            throw new EntityNotFoundException(currentClass, entityName, id.toString());
        }
    }

    /**
     * Validates if loyalty event configuration doesn't already exist
     * Throws {@link EntityAlreadyExistsException} if already exists
     * @param id Loyalty Event Configuration ID
     */
    public void validateLoyaltyEventConfigurationNotExists(UUID id) {
        boolean loyaltyEventConfigurationExists = loyaltyEventFindServicePort.existsConfigurationById(id);

        if (loyaltyEventConfigurationExists) {
            throw new EntityAlreadyExistsException(currentClass, entityName, id.toString());
        }
    }

    /**
     * Validates if loyalty event configuration exists
     * Throws {@link EntityNotFoundException} if not exists
     * @param loyaltyEventId Loyalty Event ID
     * @param loyaltyProgramId Loyalty Program ID
     */
    public void validateLoyaltyEventConfigurationNotExistsByLoyaltyEventAndProgram(UUID loyaltyEventId, UUID loyaltyProgramId) {
        boolean loyaltyEventConfigurationExists = loyaltyEventFindServicePort.existsConfigurationByEventIdAndProgramId(loyaltyEventId, loyaltyProgramId);

        if (loyaltyEventConfigurationExists) {
            throw new EntityNotFoundException(currentClass, entityName, loyaltyProgramId.toString());
        }
    }
}
