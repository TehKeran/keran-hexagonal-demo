package org.keran.infrastructure.adapters.postgres.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.domain.ports.spi.loyaltyCard.LoyaltyCardFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class LoyaltyCardFindAdapter implements LoyaltyCardFindPersistencePort {
    @Override
    public LoyaltyCardDto findLoyaltyCardById(UUID id) {
        return null;
    }

    @Override
    public LoyaltyCardDto findLoyaltyCardByNumber(String cardNumber) {
        return null;
    }

    @Override
    public List<LoyaltyCardDto> getLoyaltyCardsByCustomerId(UUID customerId) {
        return null;
    }
}
