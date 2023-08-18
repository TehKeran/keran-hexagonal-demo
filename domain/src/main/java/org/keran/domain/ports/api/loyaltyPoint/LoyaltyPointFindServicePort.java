package org.keran.domain.ports.api.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;

import java.util.UUID;

public interface LoyaltyPointFindServicePort {
    LoyaltyPointDto findLoyaltyPointById(UUID id);
    LoyaltyPointDto findLoyaltyPointByName(String name);
}
