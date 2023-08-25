package org.keran.infrastructure.adapters.postgres.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;
import org.keran.domain.ports.spi.loyaltyProgram.LoyaltyProgramUpdatePersistencePort;
import org.springframework.stereotype.Service;

@Service

public class LoyaltyProgramUpdateAdapter implements LoyaltyProgramUpdatePersistencePort {
    @Override
    public LoyaltyProgramDto updateLoyaltyProgram(LoyaltyProgramDto loyaltyProgramDto) {
        return null;
    }
}
