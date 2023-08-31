package org.keran.domain.ports.spi.loyaltyAccount;

import java.util.UUID;

public interface LoyaltyAccountDeletePersistencePort {
    void deleteLoyaltyAccountById(UUID id);
    void deleteLoyaltyAccountTransactionHistoryById(UUID id);
    void deleteAllLoyaltyAccountTransactionHistoryByLoyaltyAccount_Id(UUID loyaltyAccountId);
}
