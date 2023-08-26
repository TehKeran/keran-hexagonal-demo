package org.keran.infrastructure.adapters.postgres.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.ports.spi.loyaltyCustomer.LoyaltyCustomerUpdatePersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyCustomer.LoyaltyCustomerPostgres;
import org.keran.infrastructure.mappers.loyaltyCustomer.LoyaltyCustomerMapper;
import org.keran.infrastructure.repository.loyaltyCustomer.LoyaltyCustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyCustomerUpdateAdapter implements LoyaltyCustomerUpdatePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyCustomerUpdateAdapter.class);
    private final LoyaltyCustomerRepository loyaltyCustomerRepository;

    public LoyaltyCustomerUpdateAdapter(LoyaltyCustomerRepository loyaltyCustomerRepository) {
        this.loyaltyCustomerRepository = loyaltyCustomerRepository;
    }

    @Override
    public Optional<LoyaltyCustomerDto> updateLoyaltyCustomer(LoyaltyCustomerDto loyaltyCustomerDto) {
        LoyaltyCustomerPostgres loyaltyCustomerPostgres = LoyaltyCustomerMapper.INSTANCE.loyaltyCustomerDtoToPostgres(loyaltyCustomerDto);
        LoyaltyCustomerPostgres loyaltyCustomerPostgresUpdated = loyaltyCustomerRepository.saveAndFlush(loyaltyCustomerPostgres);
        return Optional.of(LoyaltyCustomerMapper.INSTANCE.loyaltyCustomerPostgresToDto(loyaltyCustomerPostgresUpdated));
    }
}
