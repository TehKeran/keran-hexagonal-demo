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
}
