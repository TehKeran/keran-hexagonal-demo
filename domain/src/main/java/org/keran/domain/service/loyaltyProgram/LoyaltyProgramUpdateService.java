package org.keran.domain.service.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;
import org.keran.domain.ports.api.loyaltyProgram.LoyaltyProgramUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyProgram.LoyaltyProgramUpdatePersistencePort;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyProgramUpdateService implements LoyaltyProgramUpdateServicePort {
    private final LoyaltyProgramUpdatePersistencePort loyaltyProgramUpdatePersistencePort;

    public LoyaltyProgramUpdateService(LoyaltyProgramUpdatePersistencePort loyaltyProgramUpdatePersistencePort) {
        this.loyaltyProgramUpdatePersistencePort = loyaltyProgramUpdatePersistencePort;
    }

    @Override
    public LoyaltyProgramDto updateLoyaltyProgram(LoyaltyProgramDto loyaltyProgramDto) {
        return loyaltyProgramUpdatePersistencePort.updateLoyaltyProgram(loyaltyProgramDto);
    }
}