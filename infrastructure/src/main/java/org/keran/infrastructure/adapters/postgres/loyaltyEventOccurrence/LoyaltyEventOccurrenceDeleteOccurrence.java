package org.keran.infrastructure.adapters.postgres.loyaltyEventOccurrence;

import org.keran.domain.ports.spi.loyaltyEventOccurrence.LoyaltyEventOccurrenceDeletePersistencePort;
import org.keran.infrastructure.repository.loyaltyEventOccurrence.LoyaltyEventOccurrenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class LoyaltyEventOccurrenceDeleteOccurrence implements LoyaltyEventOccurrenceDeletePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyEventOccurrenceDeleteOccurrence.class);
    private final LoyaltyEventOccurrenceRepository loyaltyEventOccurrenceRepository;

    public LoyaltyEventOccurrenceDeleteOccurrence(LoyaltyEventOccurrenceRepository loyaltyEventOccurrenceRepository) {
        this.loyaltyEventOccurrenceRepository = loyaltyEventOccurrenceRepository;
    }

    @Override
    public void deleteLoyaltyEventOccurrenceById(UUID id) {
        loyaltyEventOccurrenceRepository.deleteById(id);
    }
}
