package org.keran.infrastructure.adapters.postgres.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.ports.spi.loyaltyCustomer.LoyaltyCustomerAddPersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyCustomer.LoyaltyCustomerPostgres;
import org.keran.infrastructure.mappers.loyaltyCustomer.LoyaltyCustomerMapper;
import org.keran.infrastructure.repository.loyaltyCustomer.LoyaltyCustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyCustomerAddAdapter implements LoyaltyCustomerAddPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyCustomerAddAdapter.class);
    private final LoyaltyCustomerRepository loyaltyCustomerRepository;

    public LoyaltyCustomerAddAdapter(LoyaltyCustomerRepository loyaltyCustomerRepository) {
        this.loyaltyCustomerRepository = loyaltyCustomerRepository;
    }

    @Override
    public Optional<LoyaltyCustomerDto> addLoyaltyCustomer(LoyaltyCustomerDto loyaltyCustomerDto) {
        LoyaltyCustomerPostgres loyaltyCustomerPostgres = LoyaltyCustomerMapper.INSTANCE.loyaltyCustomerDtoToPostgres(loyaltyCustomerDto);
        LoyaltyCustomerPostgres loyaltyCustomerPostgresCreated = loyaltyCustomerRepository.saveAndFlush(loyaltyCustomerPostgres);
        return Optional.of(LoyaltyCustomerMapper.INSTANCE.loyaltyCustomerPostgresToDto(loyaltyCustomerPostgresCreated));
    }
}
