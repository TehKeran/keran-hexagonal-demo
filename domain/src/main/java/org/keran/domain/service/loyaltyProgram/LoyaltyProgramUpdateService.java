package org.keran.domain.service.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;
import org.keran.domain.ports.api.loyaltyProgram.LoyaltyProgramUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyProgram.LoyaltyProgramUpdatePersistencePort;
import org.keran.domain.validator.loyaltyProgram.LoyaltyProgramValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyProgramUpdateService implements LoyaltyProgramUpdateServicePort {
    private final LoyaltyProgramUpdatePersistencePort loyaltyProgramUpdatePersistencePort;
    private final LoyaltyProgramValidator loyaltyProgramValidator;

    public LoyaltyProgramUpdateService(LoyaltyProgramUpdatePersistencePort loyaltyProgramUpdatePersistencePort, LoyaltyProgramValidator loyaltyProgramValidator) {
        this.loyaltyProgramUpdatePersistencePort = loyaltyProgramUpdatePersistencePort;
        this.loyaltyProgramValidator = loyaltyProgramValidator;
    }

    @Override
    public Optional<LoyaltyProgramDto> updateLoyaltyProgram(LoyaltyProgramDto loyaltyProgramDto) {
        // Business validation
        // - Entity must exist
        loyaltyProgramValidator.validateLoyaltyProgramExists(loyaltyProgramDto.getId());

        return loyaltyProgramUpdatePersistencePort.updateLoyaltyProgram(loyaltyProgramDto);
    }
}
