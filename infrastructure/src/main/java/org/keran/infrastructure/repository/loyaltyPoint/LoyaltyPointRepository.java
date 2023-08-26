package org.keran.infrastructure.repository.loyaltyPoint;

import org.keran.infrastructure.data.postgres.loyaltyPoint.LoyaltyPointPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface LoyaltyPointRepository extends JpaRepository<LoyaltyPointPostgres, UUID> {
    Optional<LoyaltyPointPostgres> findByName(String name);
}
