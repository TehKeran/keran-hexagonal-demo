package org.keran.domain.service.person;

import org.keran.domain.ports.api.person.PersonDeleteServicePort;
import org.keran.domain.ports.spi.person.PersonDeletePersistencePort;
import org.keran.domain.validator.person.PersonValidator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonDeleteService implements PersonDeleteServicePort {
    private final PersonDeletePersistencePort personDeletePersistencePort;
    private final PersonValidator personValidator;

    public PersonDeleteService(PersonDeletePersistencePort personDeletePersistencePort, PersonValidator personValidator) {
        this.personDeletePersistencePort = personDeletePersistencePort;
        this.personValidator = personValidator;
    }

    @Override
    public void deletePersonById(UUID id) {
        // Business validation
        // - Entity must exist
        personValidator.validatePersonExists(id);

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

    @Override
    public void deleteAddressByPersonId(UUID personId) {
        personDeletePersistencePort.deleteAddressByPersonId(personId);
    }

    @Override
    public void deleteConsentByLoyaltyCustomerId(UUID loyaltyCustomerId) {
        personDeletePersistencePort.deleteConsentByLoyaltyCustomerId(loyaltyCustomerId);
    }

    @Override
    public void deleteContactEmailByPersonId(UUID personId) {
        personDeletePersistencePort.deleteContactEmailByPersonId(personId);
    }

    @Override
    public void deleteContactTelephoneByPersonId(UUID personId) {
        personDeletePersistencePort.deleteContactTelephoneByPersonId(personId);
    }
}
