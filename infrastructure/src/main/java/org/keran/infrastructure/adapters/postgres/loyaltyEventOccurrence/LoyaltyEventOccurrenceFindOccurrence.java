package org.keran.infrastructure.adapters.postgres.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.domain.ports.spi.loyaltyEventOccurrence.LoyaltyEventOccurrenceFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class LoyaltyEventOccurrenceFindOccurrence implements LoyaltyEventOccurrenceFindPersistencePort {
    @Override
    public LoyaltyEventOccurrenceDto findLoyaltyEventOccurrenceById(UUID id) {
        return null;
    }

    @Override
    public List<LoyaltyEventOccurrenceDto> findLoyaltyEventOccurrencesByAccountId(UUID accountId) {
        return null;
    }

    @Override
    public List<LoyaltyEventOccurrenceDto> findLoyaltyEventOccurrencesByEventId(UUID eventId) {
        return null;
    }
}
