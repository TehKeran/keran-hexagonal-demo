package org.keran.domain.ports.spi.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;

import java.util.Optional;
import java.util.UUID;

public interface LoyaltyPointFindPersistencePort {
    Optional<LoyaltyPointDto> findLoyaltyPointById(UUID id);
    Optional<LoyaltyPointDto> findLoyaltyPointByName(String name);
    boolean existsById(UUID id);
}
