package org.keran.domain.ports.spi.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;

import java.util.Optional;

public interface LoyaltyCardAddPersistencePort {
    Optional<LoyaltyCardDto> addLoyaltyCard(LoyaltyCardDto loyaltyCardDto);

}
