package org.keran.infrastructure.repository.loyaltyAccount;

import org.keran.infrastructure.data.postgres.loyaltyAccount.LoyaltyAccountPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LoyaltyAccountRepository extends JpaRepository<LoyaltyAccountPostgres, UUID> {
    Optional<LoyaltyAccountPostgres> findByAccountNumber(String accountNumber);
    List<LoyaltyAccountPostgres> findAllByLoyaltyCustomerPostgres_Id(UUID loyaltyCustomerId);
    List<LoyaltyAccountPostgres> findAllLoyaltyAccountsByLoyaltyProgramPostgres_Id(UUID loyaltyProgramId);
    boolean existsByAccountNumber(String accountNumber);
}
