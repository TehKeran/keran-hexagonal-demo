package org.keran.domain.ports.api.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;

public interface LoyaltyPointUpdateServicePort {
    LoyaltyPointDto updateLoyaltyPoint(LoyaltyPointDto loyaltyPointDto);
}
