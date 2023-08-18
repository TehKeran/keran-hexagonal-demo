package org.keran.domain.ports.api.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;

public interface LoyaltyCardAddServicePort {
    LoyaltyCardDto addLoyaltyCard(LoyaltyCardDto loyaltyCardDto);

}
