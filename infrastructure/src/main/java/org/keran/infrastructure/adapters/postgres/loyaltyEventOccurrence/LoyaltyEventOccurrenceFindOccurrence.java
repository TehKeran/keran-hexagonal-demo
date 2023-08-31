package org.keran.infrastructure.adapters.postgres.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.domain.ports.spi.loyaltyEventOccurrence.LoyaltyEventOccurrenceFindPersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyEventOccurrence.LoyaltyEventOccurrencePostgres;
import org.keran.infrastructure.mappers.loyaltyEventOccurrence.LoyaltyEventOccurrenceMapper;
import org.keran.infrastructure.repository.loyaltyEventOccurrence.LoyaltyEventOccurrenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class LoyaltyEventOccurrenceFindOccurrence implements LoyaltyEventOccurrenceFindPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyEventOccurrenceFindOccurrence.class);
    private final LoyaltyEventOccurrenceRepository loyaltyEventOccurrenceRepository;

    public LoyaltyEventOccurrenceFindOccurrence(LoyaltyEventOccurrenceRepository loyaltyEventOccurrenceRepository) {
        this.loyaltyEventOccurrenceRepository = loyaltyEventOccurrenceRepository;
    }

    @Override
    public Optional<LoyaltyEventOccurrenceDto> findLoyaltyEventOccurrenceById(UUID id) {
        Optional<LoyaltyEventOccurrencePostgres> loyaltyEventOccurrencePostgres =
                loyaltyEventOccurrenceRepository.findById(id);

        return loyaltyEventOccurrencePostgres.map(LoyaltyEventOccurrenceMapper.INSTANCE::loyaltyEventOccurrencePostgresToDto);
    }

    @Override
    public List<LoyaltyEventOccurrenceDto> findLoyaltyEventOccurrencesByCustomerId(UUID customerId) {
        List<LoyaltyEventOccurrencePostgres> loyaltyEventOccurrencePostgresList =
                loyaltyEventOccurrenceRepository.findAllByLoyaltyCustomerPostgres_Id(customerId);

        return LoyaltyEventOccurrenceMapper.INSTANCE.loyaltyEventOccurrencePostgresListToDtoList(loyaltyEventOccurrencePostgresList);
    }

    @Override
    public List<LoyaltyEventOccurrenceDto> findLoyaltyEventOccurrencesByEventId(UUID eventId) {
        List<LoyaltyEventOccurrencePostgres> loyaltyEventOccurrencePostgresList =
                loyaltyEventOccurrenceRepository.findAllByLoyaltyEventPostgres_Id(eventId);

        return LoyaltyEventOccurrenceMapper.INSTANCE.loyaltyEventOccurrencePostgresListToDtoList(loyaltyEventOccurrencePostgresList);
    }

    @Override
    public boolean existsById(UUID id) {
        return loyaltyEventOccurrenceRepository.existsById(id);
    }
}
