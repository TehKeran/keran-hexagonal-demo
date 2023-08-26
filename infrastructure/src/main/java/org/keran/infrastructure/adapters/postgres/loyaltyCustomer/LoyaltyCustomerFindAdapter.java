package org.keran.infrastructure.adapters.postgres.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.ports.spi.loyaltyCustomer.LoyaltyCustomerFindPersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyCustomer.LoyaltyCustomerPostgres;
import org.keran.infrastructure.mappers.loyaltyCustomer.LoyaltyCustomerMapper;
import org.keran.infrastructure.repository.loyaltyCustomer.LoyaltyCustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class LoyaltyCustomerFindAdapter implements LoyaltyCustomerFindPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyCustomerFindAdapter.class);
    private final LoyaltyCustomerRepository loyaltyCustomerRepository;

    public LoyaltyCustomerFindAdapter(LoyaltyCustomerRepository loyaltyCustomerRepository) {
        this.loyaltyCustomerRepository = loyaltyCustomerRepository;
    }

    @Override
    public Optional<LoyaltyCustomerDto> findLoyaltyCustomerById(UUID id) {
        Optional<LoyaltyCustomerPostgres> loyaltyCustomerPostgres = loyaltyCustomerRepository.findById(id);
        return loyaltyCustomerPostgres.map(LoyaltyCustomerMapper.INSTANCE::loyaltyCustomerPostgresToDto);
    }

    @Override
    public Optional<LoyaltyCustomerDto> findLoyaltyCustomerByCustomerNumber(String customerNumber) {
        Optional<LoyaltyCustomerPostgres> loyaltyCustomerPostgres = loyaltyCustomerRepository.findByCustomerNumber(customerNumber);
        return loyaltyCustomerPostgres.map(LoyaltyCustomerMapper.INSTANCE::loyaltyCustomerPostgresToDto);
    }
}
