package org.keran.domain.ports.spi.person;

import org.keran.domain.data.person.*;

import java.util.UUID;

public interface PersonFindPersistencePort {
    PersonDto findPersonById(UUID id);
    PersonDto findPersonByCustomerId(UUID customerId);
    AddressDto findAddressById(UUID id);
    AddressDto findAddressByPersonId(UUID personId);
    ConsentDto findConsentById(UUID id);
    ConsentDto findConsentByCustomerId(UUID customerId);
    ContactEmailDto findContactEmailById(UUID id);
    ContactEmailDto findContactEmailByEmail(String email);
    ContactTelephoneDto findContactTelephoneById(UUID id);
    ContactTelephoneDto findContactTelephoneByCountryCodeAndNumber(String countryCode, String number);
}
