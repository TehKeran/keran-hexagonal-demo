package org.keran.domain.ports.api.person;

import org.keran.domain.data.person.*;

public interface PersonAddServicePort {
    PersonDto addPerson(PersonDto personDto);
    AddressDto addAddress(AddressDto addressDto);
    ConsentDto addConsent(ConsentDto consentDto);
    ContactEmailDto addContactEmail(ContactEmailDto contactEmailDto);
    ContactTelephoneDto addContactTelephone(ContactTelephoneDto contactTelephoneDto);
}
