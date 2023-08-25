package org.keran.infrastructure.adapters.postgres.person;

import org.keran.domain.ports.spi.person.PersonDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class PersonDeleteAdapter implements PersonDeletePersistencePort {
    @Override
    public void deletePersonById(UUID id) {

    }

    @Override
    public void deleteAddressById(UUID id) {

    }

    @Override
    public void deleteConsentById(UUID id) {

    }

    @Override
    public void deleteContactEmailById(UUID id) {

    }

    @Override
    public void deleteContactTelephoneById(UUID id) {

    }
}
