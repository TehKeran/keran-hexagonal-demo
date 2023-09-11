package org.keran.domain.ports.api.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoyaltyProgramFindServicePort {
    Optional<LoyaltyProgramDto> findLoyaltyProgramById(UUID id);
    List<LoyaltyProgramDto> getLoyaltyPrograms(int pageSize, int currentPage);
    Optional<LoyaltyProgramDto> findLoyaltyProgramByName(String name);
    boolean existsById(UUID id);
    boolean existsByName(String name);
}
