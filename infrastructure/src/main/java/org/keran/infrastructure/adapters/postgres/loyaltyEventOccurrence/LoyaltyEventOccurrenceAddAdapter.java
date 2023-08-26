package org.keran.infrastructure.adapters.postgres.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.domain.ports.spi.loyaltyEventOccurrence.LoyaltyEventOccurrenceAddPersistencePort;
import org.keran.infrastructure.adapters.postgres.loyaltyEvent.LoyaltyEventUpdateAdapter;
import org.keran.infrastructure.data.postgres.loyaltyEventOccurrence.LoyaltyEventOccurrencePostgres;
import org.keran.infrastructure.mappers.loyaltyEventOccurrence.LoyaltyEventOccurrenceMapper;
import org.keran.infrastructure.repository.loyaltyEventOccurrence.LoyaltyEventOccurrenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyEventOccurrenceAddAdapter implements LoyaltyEventOccurrenceAddPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyEventOccurrenceAddAdapter.class);
    private final LoyaltyEventOccurrenceRepository loyaltyEventOccurrenceRepository;

    public LoyaltyEventOccurrenceAddAdapter(LoyaltyEventOccurrenceRepository loyaltyEventOccurrenceRepository) {
        this.loyaltyEventOccurrenceRepository = loyaltyEventOccurrenceRepository;
    }

    @Override
    public Optional<LoyaltyEventOccurrenceDto> addLoyaltyEventOccurrence(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto) {
        LoyaltyEventOccurrencePostgres loyaltyEventOccurrencePostgres =
                LoyaltyEventOccurrenceMapper.INSTANCE.loyaltyEventOccurrenceDtoToPostgres(loyaltyEventOccurrenceDto);
        LoyaltyEventOccurrencePostgres loyaltyEventOccurrencePostgresCreated =
                loyaltyEventOccurrenceRepository.saveAndFlush(loyaltyEventOccurrencePostgres);

        return Optional.of(LoyaltyEventOccurrenceMapper.INSTANCE.loyaltyEventOccurrencePostgresToDto(loyaltyEventOccurrencePostgresCreated));
    }
}
