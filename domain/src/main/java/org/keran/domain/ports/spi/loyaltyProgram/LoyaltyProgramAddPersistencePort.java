package org.keran.domain.ports.spi.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;

import java.util.Optional;

public interface LoyaltyProgramAddPersistencePort {
    Optional<LoyaltyProgramDto> addLoyaltyProgram(LoyaltyProgramDto loyaltyProgramDto);
}
