package org.keran.domain.ports.spi.person;

import org.keran.domain.data.person.*;

public interface PersonAddPersistencePort {
    PersonDto addPerson(PersonDto personDto);
    AddressDto addAddress(AddressDto addressDto);
    ConsentDto addConsent(ConsentDto consentDto);
    ContactEmailDto addContactEmail(ContactEmailDto contactEmailDto);
    ContactTelephoneDto addContactTelephone(ContactTelephoneDto contactTelephoneDto);
}
