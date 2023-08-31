package org.keran.domain.service.loyaltyEvent;

import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventDeleteServicePort;
import org.keran.domain.ports.spi.loyaltyEvent.LoyaltyEventDeletePersistencePort;
import org.keran.domain.validator.loyaltyEvent.LoyaltyEventValidator;
import org.keran.domain.validator.loyaltyEventConfiguration.LoyaltyEventConfigurationValidator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyEventDeleteService implements LoyaltyEventDeleteServicePort {
    private final LoyaltyEventDeletePersistencePort loyaltyEventDeletePersistencePort;
    private final LoyaltyEventValidator loyaltyEventValidator;
    private final LoyaltyEventConfigurationValidator loyaltyEventConfigurationValidator;

    public LoyaltyEventDeleteService(LoyaltyEventDeletePersistencePort loyaltyEventDeletePersistencePort, LoyaltyEventValidator loyaltyEventValidator, LoyaltyEventConfigurationValidator loyaltyEventConfigurationValidator) {
        this.loyaltyEventDeletePersistencePort = loyaltyEventDeletePersistencePort;
        this.loyaltyEventValidator = loyaltyEventValidator;
        this.loyaltyEventConfigurationValidator = loyaltyEventConfigurationValidator;
    }

    @Override
    public void deleteLoyaltyEventById(UUID id) {
        // Business validation
        // - loyalty event must exist
        loyaltyEventValidator.validateLoyaltyEventExists(id);

        loyaltyEventDeletePersistencePort.deleteLoyaltyEventById(id);
    }

    @Override
    public void deleteLoyaltyEventConfigurationById(UUID id) {
        // Business validation
        // - Entity must exist
        loyaltyEventConfigurationValidator.validateLoyaltyEventConfigurationExists(id);

        loyaltyEventDeletePersistencePort.deleteLoyaltyEventConfigurationById(id);
    }

    @Override
    public void deleteAllLoyaltyEventConfigurationByLoyaltyEventId(UUID loyaltyEventId) {
        loyaltyEventDeletePersistencePort.deleteAllLoyaltyEventConfigurationByLoyaltyEventId(loyaltyEventId);
    }

    @Override
    public void deleteAllLoyaltyEventConfigurationByLoyaltyProgramId(UUID loyaltyProgramId) {
        loyaltyEventDeletePersistencePort.deleteAllLoyaltyEventConfigurationByLoyaltyProgramId(loyaltyProgramId);
    }
}
