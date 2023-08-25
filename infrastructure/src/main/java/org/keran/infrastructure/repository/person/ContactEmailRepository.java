package org.keran.infrastructure.repository.person;

import org.keran.infrastructure.data.postgres.person.ContactEmailPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ContactEmailRepository extends JpaRepository<ContactEmailPostgres, UUID> {
}
