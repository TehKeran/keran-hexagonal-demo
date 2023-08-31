package org.keran.domain.service.person;

import org.keran.domain.data.person.*;
import org.keran.domain.ports.api.person.PersonUpdateServicePort;
import org.keran.domain.ports.spi.person.PersonUpdatePersistencePort;
import org.keran.domain.validator.person.PersonValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonUpdateService implements PersonUpdateServicePort {
    private final PersonUpdatePersistencePort personUpdatePersistencePort;
    private final PersonValidator personValidator;

    public PersonUpdateService(PersonUpdatePersistencePort personUpdatePersistencePort, PersonValidator personValidator) {
        this.personUpdatePersistencePort = personUpdatePersistencePort;
        this.personValidator = personValidator;
    }

    @Override
    public Optional<PersonDto> updatePerson(PersonDto personDto) {
        // Business validations:
        // - Entity must exist
        personValidator.validatePersonExists(personDto.getId());

        return personUpdatePersistencePort.updatePerson(personDto);
    }

    @Override
    public Optional<AddressDto> updateAddress(AddressDto addressDto) {
        // Business validations:
        // - Entity must exist
        personValidator.validateAddressExists(addressDto.getId());

        return personUpdatePersistencePort.updateAddress(addressDto);
    }

    @Override
    public Optional<ConsentDto> updateConsent(ConsentDto consentDto) {
        // Business validations:
        // - Entity must exist
        personValidator.validateConsentExists(consentDto.getId());

        return personUpdatePersistencePort.updateConsent(consentDto);
    }

    @Override
    public Optional<ContactEmailDto> updateContactEmail(ContactEmailDto contactEmailDto) {
        // Business validations:
        // - Entity must exist
        personValidator.validateContactEmailExists(contactEmailDto.getId());

        return personUpdatePersistencePort.updateContactEmail(contactEmailDto);
    }

    @Override
    public Optional<ContactTelephoneDto> updateContactTelephone(ContactTelephoneDto contactTelephoneDto) {
        // Business validations:
        // - Entity must exist
        personValidator.validateContactTelephoneExists(contactTelephoneDto.getId());

        return personUpdatePersistencePort.updateContactTelephone(contactTelephoneDto);
    }
}
