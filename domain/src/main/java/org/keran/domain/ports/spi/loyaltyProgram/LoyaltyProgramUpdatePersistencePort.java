package org.keran.domain.ports.spi.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;

public interface LoyaltyProgramUpdatePersistencePort {
    LoyaltyProgramDto updateLoyaltyProgram(LoyaltyProgramDto loyaltyProgramDto);
}
