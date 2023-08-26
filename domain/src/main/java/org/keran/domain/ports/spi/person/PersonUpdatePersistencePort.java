package org.keran.domain.ports.spi.person;

import org.keran.domain.data.person.*;

import java.util.Optional;

public interface PersonUpdatePersistencePort {
    Optional<PersonDto> updatePerson(PersonDto personDto);
    Optional<AddressDto> updateAddress(AddressDto addressDto);
    Optional<ConsentDto> updateConsent(ConsentDto consentDto);
    Optional<ContactEmailDto> updateContactEmail(ContactEmailDto contactEmailDto);
    Optional<ContactTelephoneDto> updateContactTelephone(ContactTelephoneDto contactTelephoneDto);
}
