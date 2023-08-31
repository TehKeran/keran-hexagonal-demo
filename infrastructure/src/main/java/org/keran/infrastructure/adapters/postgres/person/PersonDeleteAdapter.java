package org.keran.infrastructure.adapters.postgres.person;

import org.keran.domain.ports.spi.person.PersonDeletePersistencePort;
import org.keran.infrastructure.repository.person.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class PersonDeleteAdapter implements PersonDeletePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(PersonDeleteAdapter.class);
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;
    private final ConsentRepository consentRepository;
    private final ContactEmailRepository contactEmailRepository;
    private final ContactTelephoneRepository contactTelephoneRepository;

    public PersonDeleteAdapter(PersonRepository personRepository, AddressRepository addressRepository,
                               ConsentRepository consentRepository, ContactEmailRepository contactEmailRepository,
                               ContactTelephoneRepository contactTelephoneRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
        this.consentRepository = consentRepository;
        this.contactEmailRepository = contactEmailRepository;
        this.contactTelephoneRepository = contactTelephoneRepository;
    }

    @Override
    public void deletePersonById(UUID id) {
        // Delete addresses
        addressRepository.deleteByPersonPostgres_Id(id);

        // Delete telephones
        contactTelephoneRepository.deleteByPersonPostgres_Id(id);

        // Delete emails
        contactEmailRepository.deleteByPersonPostgres_Id(id);

        personRepository.deleteById(id);
    }

    @Override
    public void deleteAddressById(UUID id) {
        addressRepository.deleteById(id);
    }

    @Override
    public void deleteConsentById(UUID id) {
        consentRepository.deleteById(id);
    }

    @Override
    public void deleteContactEmailById(UUID id) {
        contactEmailRepository.deleteById(id);
    }

    @Override
    public void deleteContactTelephoneById(UUID id) {
        contactTelephoneRepository.deleteById(id);
    }

    @Override
    public void deleteAddressByPersonId(UUID personId) {
        addressRepository.deleteByPersonPostgres_Id(personId);
    }

    @Override
    public void deleteConsentByLoyaltyCustomerId(UUID loyaltyCustomerId) {
        consentRepository.deleteByLoyaltyCustomerPostgres_Id(loyaltyCustomerId);
    }

    @Override
    public void deleteContactEmailByPersonId(UUID personId) {
        contactEmailRepository.deleteByPersonPostgres_Id(personId);
    }

    @Override
    public void deleteContactTelephoneByPersonId(UUID personId) {
        contactTelephoneRepository.deleteByPersonPostgres_Id(personId);
    }
}
