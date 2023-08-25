package org.keran.infrastructure.adapters.postgres.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;
import org.keran.domain.ports.spi.loyaltyEvent.LoyaltyEventFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class LoyaltyEventFindAdapter implements LoyaltyEventFindPersistencePort {
    @Override
    public LoyaltyEventDto findLoyaltyEventById(UUID id) {
        return null;
    }

    @Override
    public LoyaltyEventDto findLoyaltyEventByName(String name) {
        return null;
    }

    @Override
    public LoyaltyEventConfigurationDto findLoyaltyEventConfigurationById(UUID id) {
        return null;
    }

    @Override
    public List<LoyaltyEventConfigurationDto> getLoyaltyEventConfigurationsByProgramId(UUID programId) {
        return null;
    }
}
