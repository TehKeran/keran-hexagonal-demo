package org.keran.domain.service.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.domain.ports.api.loyaltyCard.LoyaltyCardFindServicePort;

import java.util.List;
import java.util.UUID;

public class LoyaltyCardFindService implements LoyaltyCardFindServicePort {
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
