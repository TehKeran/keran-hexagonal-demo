package org.keran.infrastructure.adapters.postgres.loyaltyCustomer;

import org.keran.domain.ports.spi.loyaltyCustomer.LoyaltyCustomerDeletePersistencePort;
import org.keran.infrastructure.adapters.postgres.loyaltyCard.LoyaltyCardUpdateAdapter;
import org.keran.infrastructure.repository.loyaltyCustomer.LoyaltyCustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class LoyaltyCustomerDeleteAdapter implements LoyaltyCustomerDeletePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyCustomerDeleteAdapter.class);
    private final LoyaltyCustomerRepository loyaltyCustomerRepository;

    public LoyaltyCustomerDeleteAdapter(LoyaltyCustomerRepository loyaltyCustomerRepository) {
        this.loyaltyCustomerRepository = loyaltyCustomerRepository;
    }

    @Override
    public void deleteLoyaltyCustomerById(UUID id) {
        loyaltyCustomerRepository.deleteById(id);
    }

    @Override
    public void deleteLoyaltyCustomerByCustomerNumber(String customerNumber) {
        loyaltyCustomerRepository.deleteByCustomerNumber(customerNumber);
    }
}
