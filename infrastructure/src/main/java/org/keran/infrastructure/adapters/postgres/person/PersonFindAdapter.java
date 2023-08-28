package org.keran.infrastructure.adapters.postgres.person;

import org.keran.domain.data.person.*;
import org.keran.domain.ports.spi.person.PersonFindPersistencePort;
import org.keran.infrastructure.data.postgres.person.*;
import org.keran.infrastructure.mappers.person.*;
import org.keran.infrastructure.repository.person.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class PersonFindAdapter implements PersonFindPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(PersonFindAdapter.class);
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;
    private final ConsentRepository consentRepository;
    private final ContactEmailRepository contactEmailRepository;
    private final ContactTelephoneRepository contactTelephoneRepository;

    public PersonFindAdapter(PersonRepository personRepository, AddressRepository addressRepository,
                             ConsentRepository consentRepository, ContactEmailRepository contactEmailRepository,
                             ContactTelephoneRepository contactTelephoneRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
        this.consentRepository = consentRepository;
        this.contactEmailRepository = contactEmailRepository;
        this.contactTelephoneRepository = contactTelephoneRepository;
    }

    @Override
    public Optional<PersonDto> findPersonById(UUID id) {
        Optional<PersonPostgres> personPostgres = personRepository.findById(id);
        return personPostgres.map(PersonMapper.INSTANCE::personPostgresToDto);
    }

    @Override
    public Optional<PersonDto> findPersonByCustomerId(UUID customerId) {
        Optional<PersonPostgres> personPostgres = personRepository.findByLoyaltyCustomerPostgres_Id(customerId);
        return personPostgres.map(PersonMapper.INSTANCE::personPostgresToDto);
    }

    @Override
    public Optional<AddressDto> findAddressById(UUID id) {
        Optional<AddressPostgres> addressPostgres = addressRepository.findById(id);
        return addressPostgres.map(AddressMapper.INSTANCE::addressPostgresToDto);
    }

    @Override
    public Optional<AddressDto> findAddressByPersonId(UUID personId) {
        Optional<AddressPostgres> addressPostgres = addressRepository.findByPersonPostgres_Id(personId);
        return addressPostgres.map(AddressMapper.INSTANCE::addressPostgresToDto);
    }

    @Override
    public Optional<ConsentDto> findConsentById(UUID id) {
        Optional<ConsentPostgres> consentPostgres = consentRepository.findById(id);
        return consentPostgres.map(ConsentMapper.INSTANCE::consentPostgresToDto);
    }

    @Override
    public Optional<ConsentDto> findConsentByCustomerId(UUID customerId) {
        Optional<ConsentPostgres> consentPostgres = consentRepository.findByLoyaltyCustomerPostgres_Id(customerId);
        return consentPostgres.map(ConsentMapper.INSTANCE::consentPostgresToDto);
    }

    @Override
    public Optional<ContactEmailDto> findContactEmailById(UUID id) {
        Optional<ContactEmailPostgres> contactEmailPostgres = contactEmailRepository.findById(id);
        return contactEmailPostgres.map(ContactEmailMapper.INSTANCE::contactEmailPostgresToDto);
    }

    @Override
    public Optional<ContactEmailDto> findContactEmailByEmail(String email) {
        Optional<ContactEmailPostgres> contactEmailPostgres = contactEmailRepository.findByEmailAddress(email);
        return contactEmailPostgres.map(ContactEmailMapper.INSTANCE::contactEmailPostgresToDto);
    }

    @Override
    public Optional<ContactTelephoneDto> findContactTelephoneById(UUID id) {
        Optional<ContactTelephonePostgres> contactTelephonePostgres = contactTelephoneRepository.findById(id);
        return contactTelephonePostgres.map(ContactTelephoneMapper.INSTANCE::contactTelephonePostgresToDto);
    }

    @Override
    public Optional<ContactTelephoneDto> findContactTelephoneByCountryCodeAndNumber(String countryCode, String number) {
        Optional<ContactTelephonePostgres> contactTelephonePostgres =
                contactTelephoneRepository.findByCountryCodeAndTelephoneNumber(countryCode, number);
        return contactTelephonePostgres.map(ContactTelephoneMapper.INSTANCE::contactTelephonePostgresToDto);
    }
}
