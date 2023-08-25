package org.keran.infrastructure.adapters.postgres.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.domain.ports.spi.loyaltyEventOccurrence.LoyaltyEventOccurrenceUpdatePersistencePort;
import org.springframework.stereotype.Service;

@Service

public class LoyaltyEventOccurrenceUpdateOccurrence implements LoyaltyEventOccurrenceUpdatePersistencePort{
    @Override
    public LoyaltyEventOccurrenceDto updateLoyaltyEventOccurrence(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto) {
        return null;
    }
}
