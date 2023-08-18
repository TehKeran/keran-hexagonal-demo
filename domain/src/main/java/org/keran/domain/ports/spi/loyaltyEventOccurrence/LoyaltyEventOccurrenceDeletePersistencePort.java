package org.keran.domain.ports.spi.loyaltyEventOccurrence;

import java.util.UUID;

public interface LoyaltyEventOccurrenceDeletePersistencePort {
    void deleteLoyaltyEventOccurrenceById(UUID id);
}
