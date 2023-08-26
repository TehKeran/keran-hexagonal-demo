package org.keran.domain.ports.spi.person;

import org.keran.domain.data.person.*;

import java.util.Optional;

public interface PersonAddPersistencePort {
    Optional<PersonDto> addPerson(PersonDto personDto);
    Optional<AddressDto> addAddress(AddressDto addressDto);
    Optional<ConsentDto> addConsent(ConsentDto consentDto);
    Optional<ContactEmailDto> addContactEmail(ContactEmailDto contactEmailDto);
    Optional<ContactTelephoneDto> addContactTelephone(ContactTelephoneDto contactTelephoneDto);
}
