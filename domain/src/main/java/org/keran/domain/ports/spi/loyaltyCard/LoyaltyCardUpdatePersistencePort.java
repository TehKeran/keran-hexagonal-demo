package org.keran.domain.ports.spi.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;

import java.util.Optional;

public interface LoyaltyCardUpdatePersistencePort {
    Optional<LoyaltyCardDto> updateLoyaltyCard(LoyaltyCardDto loyaltyCardDto);

}
