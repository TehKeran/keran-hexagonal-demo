package org.keran.domain.ports.api.person;

import org.keran.domain.data.person.*;

public interface PersonUpdateServicePort {
    PersonDto updatePerson(PersonDto personDto);
    AddressDto updateAddress(AddressDto addressDto);
    ConsentDto updateConsent(ConsentDto consentDto);
    ContactEmailDto updateContactEmail(ContactEmailDto contactEmailDto);
    ContactTelephoneDto updateContactTelephone(ContactTelephoneDto contactTelephoneDto);
}
