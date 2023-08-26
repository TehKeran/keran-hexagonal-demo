package org.keran.domain.ports.spi.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoyaltyEventFindPersistencePort {
    Optional<LoyaltyEventDto> findLoyaltyEventById(UUID id);
    Optional<LoyaltyEventDto> findLoyaltyEventByName(String name);
    Optional<LoyaltyEventConfigurationDto> findLoyaltyEventConfigurationById(UUID id);
    List<LoyaltyEventConfigurationDto> getLoyaltyEventConfigurationsByProgramId(UUID programId);
}
