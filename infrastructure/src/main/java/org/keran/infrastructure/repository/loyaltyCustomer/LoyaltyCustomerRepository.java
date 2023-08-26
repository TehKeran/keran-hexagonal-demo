package org.keran.infrastructure.repository.loyaltyCustomer;

import org.keran.infrastructure.data.postgres.loyaltyCustomer.LoyaltyCustomerPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface LoyaltyCustomerRepository extends JpaRepository<LoyaltyCustomerPostgres, UUID> {
    void deleteByCustomerNumber(String customerNumber);
    Optional<LoyaltyCustomerPostgres> findByCustomerNumber(String customerNumber);
}
