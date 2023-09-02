package org.keran.domain.service.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;
import org.keran.domain.ports.api.loyaltyProgram.LoyaltyProgramAddServicePort;
import org.keran.domain.ports.spi.loyaltyProgram.LoyaltyProgramAddPersistencePort;
import org.keran.domain.validator.loyaltyProgram.LoyaltyProgramValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyProgramAddService implements LoyaltyProgramAddServicePort {
    private final LoyaltyProgramAddPersistencePort loyaltyProgramAddPersistencePort;
    private final LoyaltyProgramValidator loyaltyProgramValidator;

    public LoyaltyProgramAddService(LoyaltyProgramAddPersistencePort loyaltyProgramAddPersistencePort, LoyaltyProgramValidator loyaltyProgramValidator) {
        this.loyaltyProgramAddPersistencePort = loyaltyProgramAddPersistencePort;
        this.loyaltyProgramValidator = loyaltyProgramValidator;
    }

    @Override
    public Optional<LoyaltyProgramDto> addLoyaltyProgram(LoyaltyProgramDto loyaltyProgramDto) {
        // Business validation
        // - If ID is provided: Entity must not exist
        if (loyaltyProgramDto.getId() != null) {
            loyaltyProgramValidator.validateLoyaltyProgramNotExists(loyaltyProgramDto.getId());
        }
        // - Name must be unique
        loyaltyProgramValidator.validateLoyaltyProgramNotExistsByName(loyaltyProgramDto.getName());

        return loyaltyProgramAddPersistencePort.addLoyaltyProgram(loyaltyProgramDto);
    }
}
