package org.keran.infrastructure.adapters.postgres.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;
import org.keran.domain.ports.spi.loyaltyProgram.LoyaltyProgramFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class LoyaltyProgramFindAdapter implements LoyaltyProgramFindPersistencePort {
    @Override
    public LoyaltyProgramDto findLoyaltyProgramById(UUID id) {
        return null;
    }

    @Override
    public LoyaltyProgramDto findLoyaltyProgramByName(String name) {
        return null;
    }
}
