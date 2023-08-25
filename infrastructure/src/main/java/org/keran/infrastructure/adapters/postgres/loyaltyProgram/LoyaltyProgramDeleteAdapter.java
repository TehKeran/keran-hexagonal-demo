package org.keran.infrastructure.adapters.postgres.loyaltyProgram;

import org.keran.domain.ports.spi.loyaltyProgram.LoyaltyProgramDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class LoyaltyProgramDeleteAdapter implements LoyaltyProgramDeletePersistencePort {
    @Override
    public void deleteLoyaltyProgramById(UUID id) {

    }
}
