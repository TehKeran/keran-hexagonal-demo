package org.keran.domain.ports.api.loyaltyProgram;

import java.util.UUID;

public interface LoyaltyProgramDeleteServicePort {
    void deleteLoyaltyProgramById(UUID id);
}
