package org.keran.infrastructure.adapters.postgres.loyaltyEventOccurrence;

import org.keran.domain.ports.spi.loyaltyEventOccurrence.LoyaltyEventOccurrenceDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class LoyaltyEventOccurrenceDeleteOccurrence implements LoyaltyEventOccurrenceDeletePersistencePort {
    @Override
    public void deleteLoyaltyEventOccurrenceById(UUID id) {

    }
}
