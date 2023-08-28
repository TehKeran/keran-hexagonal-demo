package org.keran.domain.service.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.domain.ports.api.loyaltyEventOccurrence.LoyaltyEventOccurrenceAddServicePort;
import org.keran.domain.ports.spi.loyaltyEventOccurrence.LoyaltyEventOccurrenceAddPersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyEventOccurrenceAddService implements LoyaltyEventOccurrenceAddServicePort {
    private final LoyaltyEventOccurrenceAddPersistencePort loyaltyEventOccurrenceAddPersistencePort;

    public LoyaltyEventOccurrenceAddService(LoyaltyEventOccurrenceAddPersistencePort loyaltyEventOccurrenceAddPersistencePort) {
        this.loyaltyEventOccurrenceAddPersistencePort = loyaltyEventOccurrenceAddPersistencePort;
    }

    @Override
    public Optional<LoyaltyEventOccurrenceDto> addLoyaltyEventOccurrence(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto) {
        return loyaltyEventOccurrenceAddPersistencePort.addLoyaltyEventOccurrence(loyaltyEventOccurrenceDto);
    }
}
