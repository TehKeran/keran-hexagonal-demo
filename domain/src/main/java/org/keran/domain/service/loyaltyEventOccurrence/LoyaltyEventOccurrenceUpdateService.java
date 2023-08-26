package org.keran.domain.service.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.domain.ports.api.loyaltyEventOccurrence.LoyaltyEventOccurrenceUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyEventOccurrence.LoyaltyEventOccurrenceUpdatePersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyEventOccurrenceUpdateService implements LoyaltyEventOccurrenceUpdateServicePort {
    private final LoyaltyEventOccurrenceUpdatePersistencePort loyaltyEventOccurrenceUpdatePersistencePort;

    public LoyaltyEventOccurrenceUpdateService(LoyaltyEventOccurrenceUpdatePersistencePort loyaltyEventOccurrenceUpdatePersistencePort) {
        this.loyaltyEventOccurrenceUpdatePersistencePort = loyaltyEventOccurrenceUpdatePersistencePort;
    }

    @Override
    public Optional<LoyaltyEventOccurrenceDto> updateLoyaltyEventOccurrence(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto) {
        return loyaltyEventOccurrenceUpdatePersistencePort.updateLoyaltyEventOccurrence(loyaltyEventOccurrenceDto);
    }
}
