package org.keran.infrastructure.repository.person;

import org.keran.infrastructure.data.postgres.person.ContactTelephonePostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ContactTelephoneRepository extends JpaRepository<ContactTelephonePostgres, UUID> {
    Optional<ContactTelephonePostgres> findByCountryCodeAndTelephoneNumber(String countryCode, String telephoneNumber);
    void deleteByPersonPostgres_Id(UUID personId);
}
