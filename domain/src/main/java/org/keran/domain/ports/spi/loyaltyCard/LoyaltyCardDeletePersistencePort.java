package org.keran.domain.ports.spi.loyaltyCard;

import java.util.UUID;

public interface LoyaltyCardDeletePersistencePort {
    void deleteLoyaltyCardById(UUID loyaltyCardId);
    void deleteAllLoyaltyCardByLoyaltyCustomerId(UUID loyaltyCustomerId);

}
