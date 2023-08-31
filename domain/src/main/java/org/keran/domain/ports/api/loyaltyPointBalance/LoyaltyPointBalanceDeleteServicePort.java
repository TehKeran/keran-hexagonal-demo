package org.keran.domain.ports.api.loyaltyPointBalance;

import java.util.UUID;

public interface LoyaltyPointBalanceDeleteServicePort {
    void deleteLoyaltyPointBalanceById(UUID id);
    void deleteAllLoyaltyPointBalanceByLoyaltyAccountId(UUID loyaltyAccountId);
}
