package org.keran.domain.ports.spi.loyaltyProgram;

import java.util.UUID;

public interface LoyaltyProgramDeletePersistencePort {
    void deleteLoyaltyProgramById(UUID id);
}
