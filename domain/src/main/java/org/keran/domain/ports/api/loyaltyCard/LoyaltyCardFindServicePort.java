package org.keran.domain.ports.api.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;

import java.util.List;
import java.util.UUID;

public interface LoyaltyCardFindServicePort {
    LoyaltyCardDto findLoyaltyCardById(UUID id);
    LoyaltyCardDto findLoyaltyCardByNumber(String cardNumber);
    List<LoyaltyCardDto> getLoyaltyCardsByCustomerId(UUID customerId);
}
