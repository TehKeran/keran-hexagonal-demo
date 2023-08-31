package org.keran.infrastructure.repository.loyaltyEvent;

import org.keran.infrastructure.data.postgres.loyaltyEvent.LoyaltyEventPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface LoyaltyEventRepository extends JpaRepository<LoyaltyEventPostgres, UUID> {
    Optional<LoyaltyEventPostgres> findByName(String name);
    boolean existsByName(String name);
}
