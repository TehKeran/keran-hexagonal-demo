package org.keran.domain.ports.spi.person;

import org.keran.domain.data.person.*;

public interface PersonUpdatePersistencePort {
    PersonDto updatePerson(PersonDto personDto);
    AddressDto updateAddress(AddressDto addressDto);
    ConsentDto updateConsent(ConsentDto consentDto);
    ContactEmailDto updateContactEmail(ContactEmailDto contactEmailDto);
    ContactTelephoneDto updateContactTelephone(ContactTelephoneDto contactTelephoneDto);
}
