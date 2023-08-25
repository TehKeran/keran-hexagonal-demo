package org.keran.infrastructure.adapters.postgres.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.domain.ports.spi.loyaltyEventOccurrence.LoyaltyEventOccurrenceAddPersistencePort;
import org.springframework.stereotype.Service;

@Service

public class LoyaltyEventOccurrenceAddAdapter implements LoyaltyEventOccurrenceAddPersistencePort {
    @Override
    public LoyaltyEventOccurrenceDto addLoyaltyEventOccurrence(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto) {
        return null;
    }
}
