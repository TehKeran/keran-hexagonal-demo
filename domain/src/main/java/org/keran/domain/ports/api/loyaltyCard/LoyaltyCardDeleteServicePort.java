package org.keran.domain.ports.api.loyaltyCard;

import java.util.UUID;

public interface LoyaltyCardDeleteServicePort {
    void deleteLoyaltyCardById(UUID loyaltyCardId);
    void deleteAllLoyaltyCardByLoyaltyCustomerId(UUID loyaltyCustomerId);
}
