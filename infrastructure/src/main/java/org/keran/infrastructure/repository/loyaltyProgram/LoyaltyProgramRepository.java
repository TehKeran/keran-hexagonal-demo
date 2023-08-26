package org.keran.infrastructure.repository.loyaltyProgram;

import org.keran.infrastructure.data.postgres.loyaltyProgram.LoyaltyProgramPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface LoyaltyProgramRepository extends JpaRepository<LoyaltyProgramPostgres, UUID> {
    Optional<LoyaltyProgramPostgres> findByName(String name);
}
