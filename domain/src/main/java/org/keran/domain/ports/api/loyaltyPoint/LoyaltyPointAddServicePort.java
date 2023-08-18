package org.keran.domain.ports.api.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;

public interface LoyaltyPointAddServicePort {
    LoyaltyPointDto addLoyaltyPoint(LoyaltyPointDto loyaltyPointDto);
}
