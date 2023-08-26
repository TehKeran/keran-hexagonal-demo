package org.keran.domain.ports.api.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;

import java.util.Optional;

public interface LoyaltyCardAddServicePort {
    Optional<LoyaltyCardDto> addLoyaltyCard(LoyaltyCardDto loyaltyCardDto);

}
