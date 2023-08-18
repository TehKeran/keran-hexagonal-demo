package org.keran.domain.ports.api.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;

public interface LoyaltyProgramAddServicePort {
    LoyaltyProgramDto addLoyaltyProgram(LoyaltyProgramDto loyaltyProgramDto);
}
