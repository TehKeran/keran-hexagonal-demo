package org.keran.domain.ports.spi.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoyaltyProgramFindPersistencePort {
    Optional<LoyaltyProgramDto> findLoyaltyProgramById(UUID id);
    Optional<LoyaltyProgramDto> findLoyaltyProgramByName(String name);
    List<LoyaltyProgramDto> getLoyaltyPrograms(int pageSize, int currentPage);
    boolean existsById(UUID id);
    boolean existsByName(String name);
}
