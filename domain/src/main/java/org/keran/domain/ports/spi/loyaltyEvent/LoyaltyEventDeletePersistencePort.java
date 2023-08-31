package org.keran.domain.ports.spi.loyaltyEvent;

import java.util.UUID;

public interface LoyaltyEventDeletePersistencePort {
    void deleteLoyaltyEventById(UUID id);
    void deleteLoyaltyEventConfigurationById(UUID id);
    void deleteAllLoyaltyEventConfigurationByLoyaltyEventId(UUID loyaltyEventId);
    void deleteAllLoyaltyEventConfigurationByLoyaltyProgramId(UUID loyaltyProgramId);
}
