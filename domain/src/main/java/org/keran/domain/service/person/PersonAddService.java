package org.keran.domain.service.person;

import org.keran.domain.data.person.*;
import org.keran.domain.ports.api.person.PersonAddServicePort;
import org.keran.domain.ports.spi.person.PersonAddPersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonAddService implements PersonAddServicePort {
    private final PersonAddPersistencePort personAddPersistencePort;

    public PersonAddService(PersonAddPersistencePort personAddPersistencePort) {
        this.personAddPersistencePort = personAddPersistencePort;
    }

    @Override
    public Optional<PersonDto> addPerson(PersonDto personDto) {
        return personAddPersistencePort.addPerson(personDto);
    }

    @Override
    public Optional<AddressDto> addAddress(AddressDto addressDto) {
        return personAddPersistencePort.addAddress(addressDto);
    }

    @Override
    public Optional<ConsentDto> addConsent(ConsentDto consentDto) {
        return personAddPersistencePort.addConsent(consentDto);
    }

    @Override
    public Optional<ContactEmailDto> addContactEmail(ContactEmailDto contactEmailDto) {
        return personAddPersistencePort.addContactEmail(contactEmailDto);
    }

    @Override
    public Optional<ContactTelephoneDto> addContactTelephone(ContactTelephoneDto contactTelephoneDto) {
        return personAddPersistencePort.addContactTelephone(contactTelephoneDto);
    }
}
