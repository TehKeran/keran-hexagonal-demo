package org.keran.domain.service.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;
import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventFindServicePort;
import org.keran.domain.ports.spi.loyaltyEvent.LoyaltyEventFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoyaltyEventFindService implements LoyaltyEventFindServicePort {
    private final LoyaltyEventFindPersistencePort loyaltyEventFindPersistencePort;

    public LoyaltyEventFindService(LoyaltyEventFindPersistencePort loyaltyEventFindPersistencePort) {
        this.loyaltyEventFindPersistencePort = loyaltyEventFindPersistencePort;
    }

    @Override
    public LoyaltyEventDto findLoyaltyEventById(UUID id) {
        return loyaltyEventFindPersistencePort.findLoyaltyEventById(id);
    }

    @Override
    public LoyaltyEventDto findLoyaltyEventByName(String name) {
        return loyaltyEventFindPersistencePort.findLoyaltyEventByName(name);
    }

    @Override
    public LoyaltyEventConfigurationDto findLoyaltyEventConfigurationById(UUID id) {
        return loyaltyEventFindPersistencePort.findLoyaltyEventConfigurationById(id);
    }

    @Override
    public List<LoyaltyEventConfigurationDto> getLoyaltyEventConfigurationsByProgramId(UUID programId) {
        return loyaltyEventFindPersistencePort.getLoyaltyEventConfigurationsByProgramId(programId);
    }
}
