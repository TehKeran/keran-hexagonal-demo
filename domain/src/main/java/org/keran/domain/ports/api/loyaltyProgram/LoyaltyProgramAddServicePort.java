package org.keran.domain.ports.api.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;

import java.util.Optional;

public interface LoyaltyProgramAddServicePort {
    Optional<LoyaltyProgramDto> addLoyaltyProgram(LoyaltyProgramDto loyaltyProgramDto);
}
