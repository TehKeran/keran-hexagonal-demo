package org.keran.infrastructure.repository.person;

import org.keran.infrastructure.data.postgres.person.AddressPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<AddressPostgres, UUID> {
    Optional<AddressPostgres> findByPersonPostgres_Id(UUID personID);
}
