package org.keran.domain.service.person;

import org.keran.domain.data.person.*;
import org.keran.domain.ports.api.person.PersonUpdateServicePort;
import org.keran.domain.ports.spi.person.PersonUpdatePersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonUpdateService implements PersonUpdateServicePort {
    private final PersonUpdatePersistencePort personUpdatePersistencePort;

    public PersonUpdateService(PersonUpdatePersistencePort personUpdatePersistencePort) {
        this.personUpdatePersistencePort = personUpdatePersistencePort;
    }

    @Override
    public Optional<PersonDto> updatePerson(PersonDto personDto) {
        return personUpdatePersistencePort.updatePerson(personDto);
    }

    @Override
    public Optional<AddressDto> updateAddress(AddressDto addressDto) {
        return personUpdatePersistencePort.updateAddress(addressDto);
    }

    @Override
    public Optional<ConsentDto> updateConsent(ConsentDto consentDto) {
        return personUpdatePersistencePort.updateConsent(consentDto);
    }

    @Override
    public Optional<ContactEmailDto> updateContactEmail(ContactEmailDto contactEmailDto) {
        return personUpdatePersistencePort.updateContactEmail(contactEmailDto);
    }

    @Override
    public Optional<ContactTelephoneDto> updateContactTelephone(ContactTelephoneDto contactTelephoneDto) {
        return personUpdatePersistencePort.updateContactTelephone(contactTelephoneDto);
    }
}
