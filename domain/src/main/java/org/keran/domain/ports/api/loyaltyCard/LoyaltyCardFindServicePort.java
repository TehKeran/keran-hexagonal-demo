package org.keran.domain.ports.api.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoyaltyCardFindServicePort {
    Optional<LoyaltyCardDto> findLoyaltyCardById(UUID id);
    Optional<LoyaltyCardDto> findLoyaltyCardByNumber(String cardNumber);
    List<LoyaltyCardDto> getLoyaltyCardsByCustomerId(UUID customerId);
    boolean existsByLoyaltyCardId(UUID id);
    boolean existsByLoyaltyCardNumber(String cardNumber);
}
