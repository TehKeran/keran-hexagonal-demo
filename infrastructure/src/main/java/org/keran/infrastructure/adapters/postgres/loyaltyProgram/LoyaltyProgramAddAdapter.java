package org.keran.infrastructure.adapters.postgres.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;
import org.keran.domain.ports.spi.loyaltyProgram.LoyaltyProgramAddPersistencePort;
import org.springframework.stereotype.Service;

@Service

public class LoyaltyProgramAddAdapter implements LoyaltyProgramAddPersistencePort {
    @Override
    public LoyaltyProgramDto addLoyaltyProgram(LoyaltyProgramDto loyaltyProgramDto) {
        return null;
    }
}
