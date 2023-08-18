package org.keran.domain.ports.api.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;

import java.util.UUID;

public interface LoyaltyProgramFindServicePort {
    LoyaltyProgramDto findLoyaltyProgramById(UUID id);
    LoyaltyProgramDto findLoyaltyProgramByName(String name);
}
