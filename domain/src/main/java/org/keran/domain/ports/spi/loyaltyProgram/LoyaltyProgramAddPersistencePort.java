package org.keran.domain.ports.spi.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;

public interface LoyaltyProgramAddPersistencePort {
    LoyaltyProgramDto addLoyaltyProgram(LoyaltyProgramDto loyaltyProgramDto);
}
