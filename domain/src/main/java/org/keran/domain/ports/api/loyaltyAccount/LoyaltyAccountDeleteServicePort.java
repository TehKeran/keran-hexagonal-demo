package org.keran.domain.ports.api.loyaltyAccount;

import java.util.UUID;

public interface LoyaltyAccountDeleteServicePort {
    void deleteLoyaltyAccountById(UUID id);
    void deleteLoyaltyAccountTransactionHistoryById(UUID id);
    void deleteAllLoyaltyAccountTransactionHistoryByLoyaltyAccount_Id(UUID loyaltyAccountId);
}
