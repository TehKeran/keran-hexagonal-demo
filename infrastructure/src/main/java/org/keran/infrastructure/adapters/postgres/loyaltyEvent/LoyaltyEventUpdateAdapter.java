package org.keran.infrastructure.adapters.postgres.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;
import org.keran.domain.ports.spi.loyaltyEvent.LoyaltyEventUpdatePersistencePort;
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
public class LoyaltyEventUpdateAdapter implements LoyaltyEventUpdatePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyEventUpdateAdapter.class);
    private final LoyaltyEventRepository loyaltyEventRepository;

    private final LoyaltyEventConfigurationRepository loyaltyEventConfigurationRepository;

    public LoyaltyEventUpdateAdapter(LoyaltyEventRepository loyaltyEventRepository, LoyaltyEventConfigurationRepository loyaltyEventConfigurationRepository) {
        this.loyaltyEventRepository = loyaltyEventRepository;
        this.loyaltyEventConfigurationRepository = loyaltyEventConfigurationRepository;
    }

    @Override
    public Optional<LoyaltyEventDto> updateLoyaltyEvent(LoyaltyEventDto loyaltyEventDto) {
        LoyaltyEventPostgres loyaltyEventPostgres = LoyaltyEventMapper.INSTANCE.loyaltyEventDtoToPostgres(loyaltyEventDto);
        LoyaltyEventPostgres loyaltyEventPostgresUpdated = loyaltyEventRepository.saveAndFlush(loyaltyEventPostgres);

        return Optional.of(LoyaltyEventMapper.INSTANCE.loyaltyEventPostgresToDto(loyaltyEventPostgresUpdated));
    }

    @Override
    public Optional<LoyaltyEventConfigurationDto> updateLoyaltyEventConfiguration(LoyaltyEventConfigurationDto loyaltyEventConfigurationDto) {
        LoyaltyEventConfigurationPostgres loyaltyEventConfigurationPostgres =
                LoyaltyEventConfigurationMapper.INSTANCE.loyaltyEventConfigurationDtoToPostgres(loyaltyEventConfigurationDto);
        LoyaltyEventConfigurationPostgres loyaltyEventConfigurationPostgresUpdated =
                loyaltyEventConfigurationRepository.saveAndFlush(loyaltyEventConfigurationPostgres);

        return Optional.of(LoyaltyEventConfigurationMapper.INSTANCE.loyaltyEventConfigurationPostgresToDto(loyaltyEventConfigurationPostgresUpdated));
    }
}
