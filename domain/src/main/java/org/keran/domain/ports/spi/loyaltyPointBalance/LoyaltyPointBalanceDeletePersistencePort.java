package org.keran.domain.ports.spi.loyaltyPointBalance;

import java.util.UUID;

public interface LoyaltyPointBalanceDeletePersistencePort {
    void deleteLoyaltyPointBalanceById(UUID id);
    void deleteAllLoyaltyPointBalanceByLoyaltyAccountId(UUID loyaltyAccountId);
}
