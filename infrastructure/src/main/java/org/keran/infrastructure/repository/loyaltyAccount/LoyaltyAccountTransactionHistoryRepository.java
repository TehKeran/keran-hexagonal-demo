package org.keran.infrastructure.repository.loyaltyAccount;

import org.keran.infrastructure.data.postgres.loyaltyAccount.LoyaltyAccountTransactionHistoryPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface LoyaltyAccountTransactionHistoryRepository extends JpaRepository<LoyaltyAccountTransactionHistoryPostgres, UUID> {
    List<LoyaltyAccountTransactionHistoryPostgres> findAllByLoyaltyAccountPostgres_Id(UUID accountId);
    boolean existsByLoyaltyAccountPostgres_Id(UUID accountId);
    void deleteAllLoyaltyAccountTransactionHistoryByLoyaltyAccountPostgres_Id(UUID loyaltyAccountId);
}
