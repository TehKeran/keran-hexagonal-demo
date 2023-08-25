package org.keran.domain.service.loyaltyEventOccurrence;

import org.keran.domain.ports.api.loyaltyEventOccurrence.LoyaltyEventOccurrenceDeleteServicePort;
import org.keran.domain.ports.spi.loyaltyEventOccurrence.LoyaltyEventOccurrenceDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyEventOccurrenceDeleteService implements LoyaltyEventOccurrenceDeleteServicePort {
    private final LoyaltyEventOccurrenceDeletePersistencePort loyaltyEventOccurrenceDeletePersistencePort;

    public LoyaltyEventOccurrenceDeleteService(LoyaltyEventOccurrenceDeletePersistencePort loyaltyEventOccurrenceDeletePersistencePort) {
        this.loyaltyEventOccurrenceDeletePersistencePort = loyaltyEventOccurrenceDeletePersistencePort;
    }

    @Override
    public void deleteLoyaltyEventOccurrenceById(UUID id) {
        loyaltyEventOccurrenceDeletePersistencePort.deleteLoyaltyEventOccurrenceById(id);
    }
}
