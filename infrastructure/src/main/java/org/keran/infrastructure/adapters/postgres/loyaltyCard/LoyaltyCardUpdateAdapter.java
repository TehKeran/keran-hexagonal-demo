package org.keran.infrastructure.adapters.postgres.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.domain.ports.spi.loyaltyCard.LoyaltyCardUpdatePersistencePort;
import org.springframework.stereotype.Service;

@Service

public class LoyaltyCardUpdateAdapter implements LoyaltyCardUpdatePersistencePort {
    @Override
    public LoyaltyCardDto updateLoyaltyCard(LoyaltyCardDto loyaltyCardDto) {
        return null;
    }
}
