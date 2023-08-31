package org.keran.domain.service.loyaltyProgram;

import org.keran.domain.ports.api.loyaltyProgram.LoyaltyProgramDeleteServicePort;
import org.keran.domain.ports.spi.loyaltyProgram.LoyaltyProgramDeletePersistencePort;
import org.keran.domain.validator.loyaltyProgram.LoyaltyProgramValidator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyProgramDeleteService implements LoyaltyProgramDeleteServicePort {
    private final LoyaltyProgramDeletePersistencePort loyaltyProgramDeletePersistencePort;
    private final LoyaltyProgramValidator loyaltyProgramValidator;

    public LoyaltyProgramDeleteService(LoyaltyProgramDeletePersistencePort loyaltyProgramDeletePersistencePort, LoyaltyProgramValidator loyaltyProgramValidator) {
        this.loyaltyProgramDeletePersistencePort = loyaltyProgramDeletePersistencePort;
        this.loyaltyProgramValidator = loyaltyProgramValidator;
    }

    @Override
    public void deleteLoyaltyProgramById(UUID id) {
        // Business validation
        // - Entity must exist
        loyaltyProgramValidator.validateLoyaltyProgramExists(id);

        loyaltyProgramDeletePersistencePort.deleteLoyaltyProgramById(id);
    }
}
