package org.keran.infrastructure.repository.loyaltyEventOccurrence;

import org.keran.infrastructure.data.postgres.loyaltyEventOccurrence.LoyaltyEventOccurrencePostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface LoyaltyEventOccurrenceRepository extends JpaRepository<LoyaltyEventOccurrencePostgres, UUID> {
    List<LoyaltyEventOccurrencePostgres> findAllByLoyaltyAccountPostgres_Id(UUID loyaltyAccountId);
    List<LoyaltyEventOccurrencePostgres> findAllByLoyaltyEventPostgres_Id(UUID loyaltyEventId);
}
