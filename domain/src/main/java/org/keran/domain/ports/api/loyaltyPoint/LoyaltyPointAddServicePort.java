package org.keran.domain.ports.api.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;

import java.util.Optional;

public interface LoyaltyPointAddServicePort {
    Optional<LoyaltyPointDto> addLoyaltyPoint(LoyaltyPointDto loyaltyPointDto);
}
