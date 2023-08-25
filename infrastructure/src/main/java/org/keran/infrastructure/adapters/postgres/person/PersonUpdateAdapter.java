package org.keran.infrastructure.adapters.postgres.person;

import org.keran.domain.data.person.*;
import org.keran.domain.ports.spi.person.PersonUpdatePersistencePort;
import org.springframework.stereotype.Service;

@Service

public class PersonUpdateAdapter implements PersonUpdatePersistencePort {
    @Override
    public PersonDto updatePerson(PersonDto personDto) {
        return null;
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto) {
        return null;
    }

    @Override
    public ConsentDto updateConsent(ConsentDto consentDto) {
        return null;
    }

    @Override
    public ContactEmailDto updateContactEmail(ContactEmailDto contactEmailDto) {
        return null;
    }

    @Override
    public ContactTelephoneDto updateContactTelephone(ContactTelephoneDto contactTelephoneDto) {
        return null;
    }
}
