package org.keran.infrastructure.repository.loyaltyPointBalance;

import org.keran.infrastructure.data.postgres.loyaltyPointBalance.LoyaltyPointBalancePostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface LoyaltyPointBalanceRepository extends JpaRepository<LoyaltyPointBalancePostgres, UUID> {
}
