package org.keran.infrastructure.repository.loyaltyEvent;

import org.keran.infrastructure.data.postgres.loyaltyEvent.LoyaltyEventConfigurationPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LoyaltyEventConfigurationRepository extends JpaRepository<LoyaltyEventConfigurationPostgres, UUID> {
    List<LoyaltyEventConfigurationPostgres> findAllByLoyaltyProgramPostgres_Id(UUID loyaltyProgramId);
    void deleteAllByLoyaltyEventPostgres_Id(UUID loyaltyEventId);
    void deleteAllByLoyaltyProgramPostgres_Id(UUID loyaltyProgramId);
    boolean existsByLoyaltyEventPostgres_IdAndLoyaltyProgramPostgres_Id(UUID loyaltyEventId, UUID loyaltyProgramId);
}
