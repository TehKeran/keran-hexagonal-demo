package org.keran.infrastructure.adapters.postgres.person;

import org.keran.domain.data.person.*;
import org.keran.domain.ports.spi.person.PersonFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class PersonFindAdapter implements PersonFindPersistencePort {
    @Override
    public PersonDto findPersonById(UUID id) {
        return null;
    }

    @Override
    public PersonDto findPersonByCustomerId(UUID customerId) {
        return null;
    }

    @Override
    public AddressDto findAddressById(UUID id) {
        return null;
    }

    @Override
    public AddressDto findAddressByPersonId(UUID personId) {
        return null;
    }

    @Override
    public ConsentDto findConsentById(UUID id) {
        return null;
    }

    @Override
    public ConsentDto findConsentByCustomerId(UUID customerId) {
        return null;
    }

    @Override
    public ContactEmailDto findContactEmailById(UUID id) {
        return null;
    }

    @Override
    public ContactEmailDto findContactEmailByEmail(String email) {
        return null;
    }

    @Override
    public ContactTelephoneDto findContactTelephoneById(UUID id) {
        return null;
    }

    @Override
    public ContactTelephoneDto findContactTelephoneByCountryCodeAndNumber(String countryCode, String number) {
        return null;
    }
}
