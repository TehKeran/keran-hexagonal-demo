package org.keran.domain.ports.api.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;

import java.util.Optional;

public interface LoyaltyPointUpdateServicePort {
    Optional<LoyaltyPointDto> updateLoyaltyPoint(LoyaltyPointDto loyaltyPointDto);
}
