package org.keran.domain.service.person;

import org.keran.domain.data.person.*;
import org.keran.domain.ports.api.person.PersonUpdateServicePort;
import org.keran.domain.ports.spi.person.PersonUpdatePersistencePort;
import org.springframework.stereotype.Service;

@Service
public class PersonUpdateService implements PersonUpdateServicePort {
    private final PersonUpdatePersistencePort personUpdatePersistencePort;

    public PersonUpdateService(PersonUpdatePersistencePort personUpdatePersistencePort) {
        this.personUpdatePersistencePort = personUpdatePersistencePort;
    }

    @Override
    public PersonDto updatePerson(PersonDto personDto) {
        return personUpdatePersistencePort.updatePerson(personDto);
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto) {
        return personUpdatePersistencePort.updateAddress(addressDto);
    }

    @Override
    public ConsentDto updateConsent(ConsentDto consentDto) {
        return personUpdatePersistencePort.updateConsent(consentDto);
    }

    @Override
    public ContactEmailDto updateContactEmail(ContactEmailDto contactEmailDto) {
        return personUpdatePersistencePort.updateContactEmail(contactEmailDto);
    }

    @Override
    public ContactTelephoneDto updateContactTelephone(ContactTelephoneDto contactTelephoneDto) {
        return personUpdatePersistencePort.updateContactTelephone(contactTelephoneDto);
    }
}
