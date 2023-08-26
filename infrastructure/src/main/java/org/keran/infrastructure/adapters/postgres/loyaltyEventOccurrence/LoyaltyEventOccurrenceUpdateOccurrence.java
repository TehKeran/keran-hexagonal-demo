package org.keran.infrastructure.adapters.postgres.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.domain.ports.spi.loyaltyEventOccurrence.LoyaltyEventOccurrenceUpdatePersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyEventOccurrence.LoyaltyEventOccurrencePostgres;
import org.keran.infrastructure.mappers.loyaltyEventOccurrence.LoyaltyEventOccurrenceMapper;
import org.keran.infrastructure.repository.loyaltyEventOccurrence.LoyaltyEventOccurrenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyEventOccurrenceUpdateOccurrence implements LoyaltyEventOccurrenceUpdatePersistencePort{
    private static Logger logger = LoggerFactory.getLogger(LoyaltyEventOccurrenceUpdateOccurrence.class);
    private final LoyaltyEventOccurrenceRepository loyaltyEventOccurrenceRepository;

    public LoyaltyEventOccurrenceUpdateOccurrence(LoyaltyEventOccurrenceRepository loyaltyEventOccurrenceRepository) {
        this.loyaltyEventOccurrenceRepository = loyaltyEventOccurrenceRepository;
    }

    @Override
    public Optional<LoyaltyEventOccurrenceDto> updateLoyaltyEventOccurrence(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto) {
        LoyaltyEventOccurrencePostgres loyaltyEventOccurrencePostgres =
                LoyaltyEventOccurrenceMapper.INSTANCE.loyaltyEventOccurrenceDtoToPostgres(loyaltyEventOccurrenceDto);
        LoyaltyEventOccurrencePostgres loyaltyEventOccurrencePostgresUpdated =
                loyaltyEventOccurrenceRepository.saveAndFlush(loyaltyEventOccurrencePostgres);
        return Optional.of(LoyaltyEventOccurrenceMapper.INSTANCE.loyaltyEventOccurrencePostgresToDto(loyaltyEventOccurrencePostgresUpdated));
    }
}
