package org.keran.domain.ports.spi.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;

import java.util.UUID;

public interface LoyaltyProgramFindPersistencePort {
    LoyaltyProgramDto findLoyaltyProgramById(UUID id);
    LoyaltyProgramDto findLoyaltyProgramByName(String name);
}
