package org.keran.infrastructure.adapters.postgres.person;

import org.keran.domain.data.person.*;
import org.keran.domain.ports.spi.person.PersonAddPersistencePort;
import org.keran.infrastructure.adapters.postgres.loyaltyProgram.LoyaltyProgramAddAdapter;
import org.keran.infrastructure.data.postgres.person.*;
import org.keran.infrastructure.mappers.person.*;
import org.keran.infrastructure.repository.person.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonAddAdapter implements PersonAddPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(PersonAddAdapter.class);
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;
    private final ConsentRepository consentRepository;
    private final ContactEmailRepository contactEmailRepository;
    private final ContactTelephoneRepository contactTelephoneRepository;

    public PersonAddAdapter(PersonRepository personRepository, AddressRepository addressRepository,
                            ConsentRepository consentRepository, ContactEmailRepository contactEmailRepository,
                            ContactTelephoneRepository contactTelephoneRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
        this.consentRepository = consentRepository;
        this.contactEmailRepository = contactEmailRepository;
        this.contactTelephoneRepository = contactTelephoneRepository;
    }

    @Override
    public Optional<PersonDto> addPerson(PersonDto personDto) {
        PersonPostgres personPostgres = PersonMapper.INSTANCE.personDtoToPostgres(personDto);
        PersonPostgres personPostgresCreated = personRepository.saveAndFlush(personPostgres);
        return Optional.of(PersonMapper.INSTANCE.personPostgresToDto(personPostgresCreated));
    }

    @Override
    public Optional<AddressDto> addAddress(AddressDto addressDto) {
        AddressPostgres addressPostgres = AddressMapper.INSTANCE.addressDtoToPostgres(addressDto);
        AddressPostgres addressPostgresCreated = addressRepository.saveAndFlush(addressPostgres);
        return Optional.of(AddressMapper.INSTANCE.addressPostgresToDto(addressPostgresCreated));
    }

    @Override
    public Optional<ConsentDto> addConsent(ConsentDto consentDto) {
        ConsentPostgres consentPostgres = ConsentMapper.INSTANCE.consentDtoToPostgres(consentDto);
        ConsentPostgres consentPostgresCreated = consentRepository.saveAndFlush(consentPostgres);
        return Optional.of(ConsentMapper.INSTANCE.consentPostgresToDto(consentPostgresCreated));
    }

    @Override
    public Optional<ContactEmailDto> addContactEmail(ContactEmailDto contactEmailDto) {
        ContactEmailPostgres contactEmailPostgres = ContactEmailMapper.INSTANCE.contactEmailDtoToPostgres(contactEmailDto);
        ContactEmailPostgres contactEmailPostgresCreated = contactEmailRepository.saveAndFlush(contactEmailPostgres);
        return Optional.of(ContactEmailMapper.INSTANCE.contactEmailPostgresToDto(contactEmailPostgresCreated));
    }

    @Override
    public Optional<ContactTelephoneDto> addContactTelephone(ContactTelephoneDto contactTelephoneDto) {
        ContactTelephonePostgres contactTelephonePostgres = ContactTelephoneMapper.INSTANCE.contactTelephoneDtoToPostgres(contactTelephoneDto);
        ContactTelephonePostgres contactTelephonePostgresCreated = contactTelephoneRepository.saveAndFlush(contactTelephonePostgres);
        return Optional.of(ContactTelephoneMapper.INSTANCE.contactTelephonePostgresToDto(contactTelephonePostgresCreated));
    }
}
