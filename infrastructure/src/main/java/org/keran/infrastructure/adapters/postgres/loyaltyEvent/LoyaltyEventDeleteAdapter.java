package org.keran.infrastructure.adapters.postgres.loyaltyEvent;

import org.keran.domain.ports.spi.loyaltyEvent.LoyaltyEventDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class LoyaltyEventDeleteAdapter implements LoyaltyEventDeletePersistencePort {
    @Override
    public void deleteLoyaltyEventById(UUID id) {

    }

    @Override
    public void deleteLoyaltyEventConfigurationById(UUID id) {

    }
}
