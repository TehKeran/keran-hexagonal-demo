package org.keran.infrastructure.adapters.postgres.loyaltyEvent;

import org.keran.domain.ports.spi.loyaltyEvent.LoyaltyEventDeletePersistencePort;
import org.keran.infrastructure.repository.loyaltyEvent.LoyaltyEventConfigurationRepository;
import org.keran.infrastructure.repository.loyaltyEvent.LoyaltyEventRepository;
import org.keran.infrastructure.repository.loyaltyEventOccurrence.LoyaltyEventOccurrenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class LoyaltyEventDeleteAdapter implements LoyaltyEventDeletePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyEventDeleteAdapter.class);
    private final LoyaltyEventRepository loyaltyEventRepository;
    private final LoyaltyEventOccurrenceRepository loyaltyEventOccurrenceRepository;
    private final LoyaltyEventConfigurationRepository loyaltyEventConfigurationRepository;

    public LoyaltyEventDeleteAdapter(LoyaltyEventRepository loyaltyEventRepository, LoyaltyEventOccurrenceRepository loyaltyEventOccurrenceRepository, LoyaltyEventConfigurationRepository loyaltyEventConfigurationRepository) {
        this.loyaltyEventRepository = loyaltyEventRepository;
        this.loyaltyEventOccurrenceRepository = loyaltyEventOccurrenceRepository;
        this.loyaltyEventConfigurationRepository = loyaltyEventConfigurationRepository;
    }

    @Override
    public void deleteLoyaltyEventById(UUID id) {
        // Delete Loyalty Event Occurrences
        loyaltyEventOccurrenceRepository.deleteAllLoyaltyEventOccurrencesByLoyaltyEventPostgres_Id(id);
        // Delete loyalty Event Configurations
        loyaltyEventConfigurationRepository.deleteAllByLoyaltyEventPostgres_Id(id);

        loyaltyEventRepository.deleteById(id);
    }

    @Override
    public void deleteLoyaltyEventConfigurationById(UUID id) {
        loyaltyEventConfigurationRepository.deleteById(id);
    }

    @Override
    public void deleteAllLoyaltyEventConfigurationByLoyaltyEventId(UUID loyaltyEventId) {
        loyaltyEventConfigurationRepository.deleteAllByLoyaltyEventPostgres_Id(loyaltyEventId);
    }

    @Override
    public void deleteAllLoyaltyEventConfigurationByLoyaltyProgramId(UUID loyaltyProgramId) {
        loyaltyEventConfigurationRepository.deleteAllByLoyaltyProgramPostgres_Id(loyaltyProgramId);
    }
}
