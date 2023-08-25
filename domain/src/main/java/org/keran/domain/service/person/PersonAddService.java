package org.keran.domain.service.person;

import org.keran.domain.data.person.*;
import org.keran.domain.ports.api.person.PersonAddServicePort;
import org.keran.domain.ports.spi.person.PersonAddPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class PersonAddService implements PersonAddServicePort {
    private final PersonAddPersistencePort personAddPersistencePort;

    public PersonAddService(PersonAddPersistencePort personAddPersistencePort) {
        this.personAddPersistencePort = personAddPersistencePort;
    }

    @Override
    public PersonDto addPerson(PersonDto personDto) {
        return personAddPersistencePort.addPerson(personDto);
    }

    @Override
    public AddressDto addAddress(AddressDto addressDto) {
        return personAddPersistencePort.addAddress(addressDto);
    }

    @Override
    public ConsentDto addConsent(ConsentDto consentDto) {
        return personAddPersistencePort.addConsent(consentDto);
    }

    @Override
    public ContactEmailDto addContactEmail(ContactEmailDto contactEmailDto) {
        return personAddPersistencePort.addContactEmail(contactEmailDto);
    }

    @Override
    public ContactTelephoneDto addContactTelephone(ContactTelephoneDto contactTelephoneDto) {
        return personAddPersistencePort.addContactTelephone(contactTelephoneDto);
    }
}
