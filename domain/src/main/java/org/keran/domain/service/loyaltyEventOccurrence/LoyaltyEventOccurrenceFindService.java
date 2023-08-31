package org.keran.domain.service.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.domain.ports.api.loyaltyEventOccurrence.LoyaltyEventOccurrenceFindServicePort;
import org.keran.domain.ports.spi.loyaltyEventOccurrence.LoyaltyEventOccurrenceFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoyaltyEventOccurrenceFindService implements LoyaltyEventOccurrenceFindServicePort {
    private final LoyaltyEventOccurrenceFindPersistencePort loyaltyEventOccurrenceFindPersistencePort;

    public LoyaltyEventOccurrenceFindService(LoyaltyEventOccurrenceFindPersistencePort loyaltyEventOccurrenceFindPersistencePort) {
        this.loyaltyEventOccurrenceFindPersistencePort = loyaltyEventOccurrenceFindPersistencePort;
    }

    @Override
    public Optional<LoyaltyEventOccurrenceDto> findLoyaltyEventOccurrenceById(UUID id) {
        return loyaltyEventOccurrenceFindPersistencePort.findLoyaltyEventOccurrenceById(id);
    }

    @Override
    public List<LoyaltyEventOccurrenceDto> findLoyaltyEventOccurrencesByCustomerId(UUID customerId) {
        return loyaltyEventOccurrenceFindPersistencePort.findLoyaltyEventOccurrencesByCustomerId(customerId);
    }

    @Override
    public List<LoyaltyEventOccurrenceDto> findLoyaltyEventOccurrencesByEventId(UUID eventId) {
        return loyaltyEventOccurrenceFindPersistencePort.findLoyaltyEventOccurrencesByEventId(eventId);
    }

    @Override
    public boolean existsById(UUID id) {
        return loyaltyEventOccurrenceFindPersistencePort.existsById(id);
    }
}
