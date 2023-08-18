package org.keran.domain.ports.spi.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;

public interface LoyaltyCardUpdatePersistencePort {
    LoyaltyCardDto updateLoyaltyCard(LoyaltyCardDto loyaltyCardDto);

}
