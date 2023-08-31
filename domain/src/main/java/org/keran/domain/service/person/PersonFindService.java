package org.keran.domain.service.person;

import org.keran.domain.data.person.*;
import org.keran.domain.ports.api.person.PersonFindServicePort;
import org.keran.domain.ports.spi.person.PersonFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PersonFindService implements PersonFindServicePort {
    private final PersonFindPersistencePort personFindPersistencePort;

    public PersonFindService(PersonFindPersistencePort personFindPersistencePort) {
        this.personFindPersistencePort = personFindPersistencePort;
    }

    @Override
    public Optional<PersonDto> findPersonById(UUID id) {
        return personFindPersistencePort.findPersonById(id);
    }

    @Override
    public Optional<PersonDto> findPersonByCustomerId(UUID customerId) {
        return personFindPersistencePort.findPersonByCustomerId(customerId);
    }

    @Override
    public Optional<AddressDto> findAddressById(UUID id) {
        return personFindPersistencePort.findAddressById(id);
    }

    @Override
    public Optional<AddressDto> findAddressByPersonId(UUID personId) {
        return personFindPersistencePort.findAddressByPersonId(personId);
    }

    @Override
    public Optional<ConsentDto> findConsentById(UUID id) {
        return personFindPersistencePort.findConsentById(id);
    }

    @Override
    public Optional<ConsentDto> findConsentByCustomerId(UUID customerId) {
        return personFindPersistencePort.findConsentByCustomerId(customerId);
    }

    @Override
    public Optional<ContactEmailDto> findContactEmailById(UUID id) {
        return personFindPersistencePort.findContactEmailById(id);
    }

    @Override
    public Optional<ContactEmailDto> findContactEmailByEmail(String email) {
        return personFindPersistencePort.findContactEmailByEmail(email);
    }

    @Override
    public Optional<ContactTelephoneDto> findContactTelephoneById(UUID id) {
        return personFindPersistencePort.findContactTelephoneById(id);
    }

    @Override
    public Optional<ContactTelephoneDto> findContactTelephoneByCountryCodeAndNumber(String countryCode, String number) {
        return personFindPersistencePort.findContactTelephoneByCountryCodeAndNumber(countryCode, number);
    }

    @Override
    public boolean existsPersonById(UUID id) {
        return personFindPersistencePort.existsPersonById(id);
    }

    @Override
    public boolean existsAddressById(UUID id) {
        return personFindPersistencePort.existsAddressById(id);
    }

    @Override
    public boolean existsConsentById(UUID id) {
        return personFindPersistencePort.existsConsentById(id);
    }

    @Override
    public boolean existsContactEmailById(UUID id) {
        return personFindPersistencePort.existsContactEmailById(id);
    }

    @Override
    public boolean existsContactTelephoneById(UUID id) {
        return personFindPersistencePort.existsContactTelephoneById(id);
    }
}
