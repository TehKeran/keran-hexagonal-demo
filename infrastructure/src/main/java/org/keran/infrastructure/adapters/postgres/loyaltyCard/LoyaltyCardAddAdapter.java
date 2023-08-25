package org.keran.infrastructure.adapters.postgres.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.domain.ports.spi.loyaltyCard.LoyaltyCardAddPersistencePort;
import org.springframework.stereotype.Service;

@Service

public class LoyaltyCardAddAdapter implements LoyaltyCardAddPersistencePort {
    @Override
    public LoyaltyCardDto addLoyaltyCard(LoyaltyCardDto loyaltyCardDto) {
        return null;
    }
}
