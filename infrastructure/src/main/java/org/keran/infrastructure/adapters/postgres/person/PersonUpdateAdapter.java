package org.keran.infrastructure.adapters.postgres.person;

import org.keran.domain.data.person.*;
import org.keran.domain.ports.spi.person.PersonUpdatePersistencePort;
import org.keran.infrastructure.data.postgres.person.*;
import org.keran.infrastructure.mappers.person.*;
import org.keran.infrastructure.repository.person.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonUpdateAdapter implements PersonUpdatePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(PersonUpdateAdapter.class);
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;
    private final ConsentRepository consentRepository;
    private final ContactEmailRepository contactEmailRepository;
    private final ContactTelephoneRepository contactTelephoneRepository;

    public PersonUpdateAdapter(PersonRepository personRepository, AddressRepository addressRepository,
                               ConsentRepository consentRepository, ContactEmailRepository contactEmailRepository,
                               ContactTelephoneRepository contactTelephoneRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
        this.consentRepository = consentRepository;
        this.contactEmailRepository = contactEmailRepository;
        this.contactTelephoneRepository = contactTelephoneRepository;
    }

    @Override
    public Optional<PersonDto> updatePerson(PersonDto personDto) {
        PersonPostgres personPostgres = PersonMapper.INSTANCE.personDtoToPostgres(personDto);
        PersonPostgres personPostgresUpdated = personRepository.saveAndFlush(personPostgres);
        return Optional.of(PersonMapper.INSTANCE.personPostgresToDto(personPostgresUpdated));
    }

    @Override
    public Optional<AddressDto> updateAddress(AddressDto addressDto) {
        AddressPostgres addressPostgres = AddressMapper.INSTANCE.addressDtoToPostgres(addressDto);
        AddressPostgres addressPostgresUpdated = addressRepository.saveAndFlush(addressPostgres);
        return Optional.of(AddressMapper.INSTANCE.addressPostgresToDto(addressPostgresUpdated));
    }

    @Override
    public Optional<ConsentDto> updateConsent(ConsentDto consentDto) {
        ConsentPostgres consentPostgres = ConsentMapper.INSTANCE.consentDtoToPostgres(consentDto);
        ConsentPostgres consentPostgresUpdated = consentRepository.saveAndFlush(consentPostgres);
        return Optional.of(ConsentMapper.INSTANCE.consentPostgresToDto(consentPostgresUpdated));
    }

    @Override
    public Optional<ContactEmailDto> updateContactEmail(ContactEmailDto contactEmailDto) {
        ContactEmailPostgres contactEmailPostgres = ContactEmailMapper.INSTANCE.contactEmailDtoToPostgres(contactEmailDto);
        ContactEmailPostgres contactEmailPostgresUpdated = contactEmailRepository.saveAndFlush(contactEmailPostgres);
        return Optional.of(ContactEmailMapper.INSTANCE.contactEmailPostgresToDto(contactEmailPostgresUpdated));
    }

    @Override
    public Optional<ContactTelephoneDto> updateContactTelephone(ContactTelephoneDto contactTelephoneDto) {
        ContactTelephonePostgres contactTelephonePostgres = ContactTelephoneMapper.INSTANCE.contactTelephoneDtoToPostgres(contactTelephoneDto);
        ContactTelephonePostgres contactTelephonePostgresUpdated = contactTelephoneRepository.saveAndFlush(contactTelephonePostgres);
        return Optional.of(ContactTelephoneMapper.INSTANCE.contactTelephonePostgresToDto(contactTelephonePostgresUpdated));
    }
}
