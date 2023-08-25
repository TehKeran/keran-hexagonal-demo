package org.keran.infrastructure.repository.loyaltyAccount;

import org.keran.infrastructure.data.postgres.loyaltyAccount.LoyaltyAccountTransactionHistoryPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface loyaltyAccountTransactionHistoryRepository extends JpaRepository<LoyaltyAccountTransactionHistoryPostgres, UUID> {
}
