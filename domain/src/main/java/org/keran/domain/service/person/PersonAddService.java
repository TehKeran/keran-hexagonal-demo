package org.keran.domain.service.person;

import org.keran.domain.data.person.*;
import org.keran.domain.ports.api.person.PersonAddServicePort;
import org.keran.domain.ports.spi.person.PersonAddPersistencePort;
import org.keran.domain.validator.person.PersonValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonAddService implements PersonAddServicePort {
    private final PersonAddPersistencePort personAddPersistencePort;
    private final PersonValidator personValidator;

    public PersonAddService(PersonAddPersistencePort personAddPersistencePort, PersonValidator personValidator) {
        this.personAddPersistencePort = personAddPersistencePort;
        this.personValidator = personValidator;
    }

    @Override
    public Optional<PersonDto> addPerson(PersonDto personDto) {
        // Business validations:
        // - Entity should not exist
        personValidator.validatePersonNotExists(personDto.getId());

        return personAddPersistencePort.addPerson(personDto);
    }

    @Override
    public Optional<AddressDto> addAddress(AddressDto addressDto) {
        // Business validations:
        // - Entity should not exist
        personValidator.validateAddressNotExists(addressDto.getId());

        return personAddPersistencePort.addAddress(addressDto);
    }

    @Override
    public Optional<ConsentDto> addConsent(ConsentDto consentDto) {
        // Business validations:
        // - Entity should not exist
        personValidator.validateConsentNotExists(consentDto.getId());

        return personAddPersistencePort.addConsent(consentDto);
    }

    @Override
    public Optional<ContactEmailDto> addContactEmail(ContactEmailDto contactEmailDto) {
        // Business validations:
        // - Entity should not exist
        personValidator.validateContactEmailNotExists(contactEmailDto.getId());

        return personAddPersistencePort.addContactEmail(contactEmailDto);
    }

    @Override
    public Optional<ContactTelephoneDto> addContactTelephone(ContactTelephoneDto contactTelephoneDto) {
        // Business validations:
        // - Entity should not exist
        personValidator.validateContactTelephoneNotExists(contactTelephoneDto.getId());

        return personAddPersistencePort.addContactTelephone(contactTelephoneDto);
    }
}
