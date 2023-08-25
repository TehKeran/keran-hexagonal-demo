package org.keran.domain.service.loyaltyProgram;

import org.keran.domain.ports.api.loyaltyProgram.LoyaltyProgramDeleteServicePort;
import org.keran.domain.ports.spi.loyaltyProgram.LoyaltyProgramDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyProgramDeleteService implements LoyaltyProgramDeleteServicePort {
    private final LoyaltyProgramDeletePersistencePort loyaltyProgramDeletePersistencePort;

    public LoyaltyProgramDeleteService(LoyaltyProgramDeletePersistencePort loyaltyProgramDeletePersistencePort) {
        this.loyaltyProgramDeletePersistencePort = loyaltyProgramDeletePersistencePort;
    }

    @Override
    public void deleteLoyaltyProgramById(UUID id) {
        loyaltyProgramDeletePersistencePort.deleteLoyaltyProgramById(id);
    }
}
