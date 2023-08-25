package org.keran.infrastructure.adapters.postgres.person;

import org.keran.domain.data.person.*;
import org.keran.domain.ports.spi.person.PersonAddPersistencePort;
import org.springframework.stereotype.Service;

@Service

public class PersonAddAdapter implements PersonAddPersistencePort {
    @Override
    public PersonDto addPerson(PersonDto personDto) {
        return null;
    }

    @Override
    public AddressDto addAddress(AddressDto addressDto) {
        return null;
    }

    @Override
    public ConsentDto addConsent(ConsentDto consentDto) {
        return null;
    }

    @Override
    public ContactEmailDto addContactEmail(ContactEmailDto contactEmailDto) {
        return null;
    }

    @Override
    public ContactTelephoneDto addContactTelephone(ContactTelephoneDto contactTelephoneDto) {
        return null;
    }
}
