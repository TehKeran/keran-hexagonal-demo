package org.keran.domain.ports.spi.person;

import org.keran.domain.data.person.*;

import java.util.Optional;
import java.util.UUID;

public interface PersonFindPersistencePort {
    Optional<PersonDto> findPersonById(UUID id);
    Optional<PersonDto> findPersonByCustomerId(UUID customerId);
    Optional<AddressDto> findAddressById(UUID id);
    Optional<AddressDto> findAddressByPersonId(UUID personId);
    Optional<ConsentDto> findConsentById(UUID id);
    Optional<ConsentDto> findConsentByCustomerId(UUID customerId);
    Optional<ContactEmailDto> findContactEmailById(UUID id);
    Optional<ContactEmailDto> findContactEmailByEmail(String email);
    Optional<ContactTelephoneDto> findContactTelephoneById(UUID id);
    Optional<ContactTelephoneDto> findContactTelephoneByCountryCodeAndNumber(String countryCode, String number);
    boolean existsPersonById(UUID id);
    boolean existsAddressById(UUID id);
    boolean existsConsentById(UUID id);
    boolean existsContactEmailById(UUID id);
    boolean existsContactTelephoneById(UUID id);

}
