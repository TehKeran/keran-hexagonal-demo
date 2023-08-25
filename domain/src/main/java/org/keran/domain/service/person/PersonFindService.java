package org.keran.domain.service.person;

import org.keran.domain.data.person.*;
import org.keran.domain.ports.api.person.PersonFindServicePort;
import org.keran.domain.ports.spi.person.PersonFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonFindService implements PersonFindServicePort {
    private final PersonFindPersistencePort personFindPersistencePort;

    public PersonFindService(PersonFindPersistencePort personFindPersistencePort) {
        this.personFindPersistencePort = personFindPersistencePort;
    }

    @Override
    public PersonDto findPersonById(UUID id) {
        return personFindPersistencePort.findPersonById(id);
    }

    @Override
    public PersonDto findPersonByCustomerId(UUID customerId) {
        return personFindPersistencePort.findPersonByCustomerId(customerId);
    }

    @Override
    public AddressDto findAddressById(UUID id) {
        return personFindPersistencePort.findAddressById(id);
    }

    @Override
    public AddressDto findAddressByPersonId(UUID personId) {
        return personFindPersistencePort.findAddressByPersonId(personId);
    }

    @Override
    public ConsentDto findConsentById(UUID id) {
        return personFindPersistencePort.findConsentById(id);
    }

    @Override
    public ConsentDto findConsentByCustomerId(UUID customerId) {
        return personFindPersistencePort.findConsentByCustomerId(customerId);
    }

    @Override
    public ContactEmailDto findContactEmailById(UUID id) {
        return personFindPersistencePort.findContactEmailById(id);
    }

    @Override
    public ContactEmailDto findContactEmailByEmail(String email) {
        return personFindPersistencePort.findContactEmailByEmail(email);
    }

    @Override
    public ContactTelephoneDto findContactTelephoneById(UUID id) {
        return personFindPersistencePort.findContactTelephoneById(id);
    }

    @Override
    public ContactTelephoneDto findContactTelephoneByCountryCodeAndNumber(String countryCode, String number) {
        return personFindPersistencePort.findContactTelephoneByCountryCodeAndNumber(countryCode, number);
    }
}
