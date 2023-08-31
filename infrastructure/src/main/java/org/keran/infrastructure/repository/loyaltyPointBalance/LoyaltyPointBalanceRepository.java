package org.keran.infrastructure.repository.loyaltyPointBalance;

import org.keran.infrastructure.data.postgres.loyaltyPointBalance.LoyaltyPointBalancePostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface LoyaltyPointBalanceRepository extends JpaRepository<LoyaltyPointBalancePostgres, UUID> {
    List<LoyaltyPointBalancePostgres> findAllByLoyaltyAccountPostgres_Id(UUID loyaltyAccountId);
    List<LoyaltyPointBalancePostgres> findAllByLoyaltyAccountPostgres_IdAndLoyaltyPointPostgres_Id(UUID loyaltyAccountId, UUID loyaltyPointId);
    void deleteAllLoyaltyPointBalanceByLoyaltyAccountPostgres_Id(UUID loyaltyAccountId);
}
