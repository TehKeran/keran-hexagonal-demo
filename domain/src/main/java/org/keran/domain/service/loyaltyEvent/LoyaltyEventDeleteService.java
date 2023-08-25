package org.keran.domain.service.loyaltyEvent;

import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventDeleteServicePort;
import org.keran.domain.ports.spi.loyaltyEvent.LoyaltyEventDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyEventDeleteService implements LoyaltyEventDeleteServicePort {
    private final LoyaltyEventDeletePersistencePort loyaltyEventDeletePersistencePort;

    public LoyaltyEventDeleteService(LoyaltyEventDeletePersistencePort loyaltyEventDeletePersistencePort) {
        this.loyaltyEventDeletePersistencePort = loyaltyEventDeletePersistencePort;
    }

    @Override
    public void deleteLoyaltyEventById(UUID id) {
        loyaltyEventDeletePersistencePort.deleteLoyaltyEventById(id);
    }

    @Override
    public void deleteLoyaltyEventConfigurationById(UUID id) {
        loyaltyEventDeletePersistencePort.deleteLoyaltyEventConfigurationById(id);
    }
}
