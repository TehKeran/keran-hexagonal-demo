package org.keran.infrastructure.repository.loyaltyCard;

import org.keran.infrastructure.data.postgres.loyaltyCard.LoyaltyCardPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface LoyaltyCardRepository extends JpaRepository<LoyaltyCardPostgres, UUID> {
}
