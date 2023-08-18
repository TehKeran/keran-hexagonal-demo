package org.keran.domain.ports.api.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;

public interface LoyaltyProgramUpdateServicePort {
    LoyaltyProgramDto updateLoyaltyProgram(LoyaltyProgramDto loyaltyProgramDto);
}
