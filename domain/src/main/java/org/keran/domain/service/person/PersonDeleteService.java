package org.keran.domain.service.person;

import org.keran.domain.ports.api.person.PersonDeleteServicePort;
import org.keran.domain.ports.spi.person.PersonDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonDeleteService implements PersonDeleteServicePort {
    private final PersonDeletePersistencePort personDeletePersistencePort;

    public PersonDeleteService(PersonDeletePersistencePort personDeletePersistencePort) {
        this.personDeletePersistencePort = personDeletePersistencePort;
    }

    @Override
    public void deletePersonById(UUID id) {
        personDeletePersistencePort.deletePersonById(id);
    }

    @Override
    public void deleteAddressById(UUID id) {
        personDeletePersistencePort.deleteAddressById(id);
    }

    @Override
    public void deleteConsentById(UUID id) {
        personDeletePersistencePort.deleteConsentById(id);
    }

    @Override
    public void deleteContactEmailById(UUID id) {
        personDeletePersistencePort.deleteContactEmailById(id);
    }

    @Override
    public void deleteContactTelephoneById(UUID id) {
        personDeletePersistencePort.deleteContactTelephoneById(id);
    }
}
