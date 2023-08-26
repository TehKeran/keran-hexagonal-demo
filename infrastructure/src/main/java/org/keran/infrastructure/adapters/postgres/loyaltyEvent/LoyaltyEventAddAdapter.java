package org.keran.infrastructure.adapters.postgres.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;
import org.keran.domain.ports.spi.loyaltyEvent.LoyaltyEventAddPersistencePort;
import org.keran.infrastructure.adapters.postgres.loyaltyCustomer.LoyaltyCustomerUpdateAdapter;
import org.keran.infrastructure.data.postgres.loyaltyEvent.LoyaltyEventConfigurationPostgres;
import org.keran.infrastructure.data.postgres.loyaltyEvent.LoyaltyEventPostgres;
import org.keran.infrastructure.mappers.loyaltyEvent.LoyaltyEventConfigurationMapper;
import org.keran.infrastructure.mappers.loyaltyEvent.LoyaltyEventMapper;
import org.keran.infrastructure.repository.loyaltyEvent.LoyaltyEventConfigurationRepository;
import org.keran.infrastructure.repository.loyaltyEvent.LoyaltyEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyEventAddAdapter implements LoyaltyEventAddPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyEventAddAdapter.class);
    private final LoyaltyEventRepository loyaltyEventRepository;
    private final LoyaltyEventConfigurationRepository loyaltyEventConfigurationRepository;

    public LoyaltyEventAddAdapter(LoyaltyEventRepository loyaltyEventRepository, LoyaltyEventConfigurationRepository loyaltyEventConfigurationRepository) {
        this.loyaltyEventRepository = loyaltyEventRepository;
        this.loyaltyEventConfigurationRepository = loyaltyEventConfigurationRepository;
    }

    @Override
    public Optional<LoyaltyEventDto> addLoyaltyEvent(LoyaltyEventDto loyaltyEventDto) {
        LoyaltyEventPostgres loyaltyEventPostgres = LoyaltyEventMapper.INSTANCE.loyaltyEventDtoToPostgres(loyaltyEventDto);
        LoyaltyEventPostgres loyaltyEventPostgresCreated = loyaltyEventRepository.saveAndFlush(loyaltyEventPostgres);

        return Optional.of(LoyaltyEventMapper.INSTANCE.loyaltyEventPostgresToDto(loyaltyEventPostgresCreated));
    }

    @Override
    public Optional<LoyaltyEventConfigurationDto> addLoyaltyEventConfigurationDto(LoyaltyEventConfigurationDto loyaltyEventConfigurationDto) {
        LoyaltyEventConfigurationPostgres loyaltyEventConfigurationPostgres =
                LoyaltyEventConfigurationMapper.INSTANCE.loyaltyEventConfigurationDtoToPostgres(loyaltyEventConfigurationDto);
        LoyaltyEventConfigurationPostgres
                loyaltyEventConfigurationPostgresCreated = loyaltyEventConfigurationRepository.
                saveAndFlush(loyaltyEventConfigurationPostgres);

        return Optional.of(LoyaltyEventConfigurationMapper.INSTANCE.
                loyaltyEventConfigurationPostgresToDto(loyaltyEventConfigurationPostgresCreated));
    }
}
