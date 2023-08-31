package org.keran.domain.ports.api.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;

import java.util.Optional;
import java.util.UUID;

public interface LoyaltyPointFindServicePort {
    Optional<LoyaltyPointDto> findLoyaltyPointById(UUID id);
    Optional<LoyaltyPointDto> findLoyaltyPointByName(String name);
    boolean existsById(UUID id);
}
