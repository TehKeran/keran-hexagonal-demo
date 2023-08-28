package org.keran.infrastructure.repository.person;

import org.keran.infrastructure.data.postgres.person.ConsentPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ConsentRepository extends JpaRepository<ConsentPostgres, UUID> {
    Optional<ConsentPostgres> findByLoyaltyCustomerPostgres_Id(UUID customerId);
}
