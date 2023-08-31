package org.keran.infrastructure.adapters.postgres.loyaltyCustomer;

import org.keran.domain.ports.spi.loyaltyCustomer.LoyaltyCustomerDeletePersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyAccount.LoyaltyAccountPostgres;
import org.keran.infrastructure.data.postgres.person.PersonPostgres;
import org.keran.infrastructure.repository.loyaltyAccount.LoyaltyAccountRepository;
import org.keran.infrastructure.repository.loyaltyAccount.LoyaltyAccountTransactionHistoryRepository;
import org.keran.infrastructure.repository.loyaltyCard.LoyaltyCardRepository;
import org.keran.infrastructure.repository.loyaltyCustomer.LoyaltyCustomerRepository;
import org.keran.infrastructure.repository.loyaltyPointBalance.LoyaltyPointBalanceRepository;
import org.keran.infrastructure.repository.person.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class LoyaltyCustomerDeleteAdapter implements LoyaltyCustomerDeletePersistencePort {
    private final LoyaltyCustomerRepository loyaltyCustomerRepository;
    private final LoyaltyAccountRepository loyaltyAccountRepository;
    private final LoyaltyAccountTransactionHistoryRepository loyaltyAccountTransactionHistoryRepository;
    private final LoyaltyPointBalanceRepository loyaltyPointBalanceRepository;
    private final LoyaltyCardRepository loyaltyCardRepository;
    private final PersonRepository personRepository;
    private final ConsentRepository consentRepository;
    private final AddressRepository addressRepository;
    private final ContactTelephoneRepository contactTelephoneRepository;
    private final ContactEmailRepository contactEmailRepository;

    public LoyaltyCustomerDeleteAdapter(LoyaltyCustomerRepository loyaltyCustomerRepository, LoyaltyAccountRepository loyaltyAccountRepository, LoyaltyAccountTransactionHistoryRepository loyaltyAccountTransactionHistoryRepository, LoyaltyPointBalanceRepository loyaltyPointBalanceRepository, LoyaltyCardRepository loyaltyCardRepository, PersonRepository personRepository, ConsentRepository consentRepository, AddressRepository addressRepository, ContactTelephoneRepository contactTelephoneRepository, ContactEmailRepository contactEmailRepository) {
        this.loyaltyCustomerRepository = loyaltyCustomerRepository;
        this.loyaltyAccountRepository = loyaltyAccountRepository;
        this.loyaltyAccountTransactionHistoryRepository = loyaltyAccountTransactionHistoryRepository;
        this.loyaltyPointBalanceRepository = loyaltyPointBalanceRepository;
        this.loyaltyCardRepository = loyaltyCardRepository;
        this.personRepository = personRepository;
        this.consentRepository = consentRepository;
        this.addressRepository = addressRepository;
        this.contactTelephoneRepository = contactTelephoneRepository;
        this.contactEmailRepository = contactEmailRepository;
    }

    @Override
    public void deleteLoyaltyCustomerById(UUID id) {
        List<LoyaltyAccountPostgres> loyaltyAccountPostgresList = loyaltyAccountRepository.findAllByLoyaltyCustomerPostgres_Id(id);
        for (LoyaltyAccountPostgres loyaltyAccountPostgres : loyaltyAccountPostgresList) {
            UUID loyaltyAccountId = loyaltyAccountPostgres.getId();
            // Delete Loyalty account transaction histories
            loyaltyAccountTransactionHistoryRepository.deleteAllLoyaltyAccountTransactionHistoryByLoyaltyAccountPostgres_Id(loyaltyAccountId);
            // Delete Loyalty point balances
            loyaltyPointBalanceRepository.deleteAllLoyaltyPointBalanceByLoyaltyAccountPostgres_Id(loyaltyAccountId);
            // Delete Loyalty accounts:
            loyaltyAccountRepository.deleteById(loyaltyAccountId);
        }

        // Delete Loyalty cards:
        loyaltyCardRepository.deleteAllLoyaltyCardsByLoyaltyCustomerPostgres_Id(id);

        // Delete Consents
        consentRepository.deleteByLoyaltyCustomerPostgres_Id(id);

        Optional<PersonPostgres> personPostgres = personRepository.findByLoyaltyCustomerPostgres_Id(id);
        if (personPostgres.isPresent()) {
            UUID personId = personPostgres.get().getId();
            // Delete Person - Address
            addressRepository.deleteByPersonPostgres_Id(personId);
            // Delete Person - Contact Email
            contactEmailRepository.deleteByPersonPostgres_Id(personId);
            // Delete Person - Contact Telephone
            contactEmailRepository.deleteByPersonPostgres_Id(personId);
            // Delete person:
            personRepository.deleteById(personId);
        }

        loyaltyCustomerRepository.deleteById(id);
    }

    @Override
    public void deleteLoyaltyCustomerByCustomerNumber(String customerNumber) {
        loyaltyCustomerRepository.deleteByCustomerNumber(customerNumber);
    }
}
