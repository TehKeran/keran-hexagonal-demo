package org.keran.infrastructure.adapters.postgres.loyaltyEvent;

import org.keran.domain.ports.spi.loyaltyEvent.LoyaltyEventDeletePersistencePort;
import org.keran.infrastructure.repository.loyaltyEvent.LoyaltyEventConfigurationRepository;
import org.keran.infrastructure.repository.loyaltyEvent.LoyaltyEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class LoyaltyEventDeleteAdapter implements LoyaltyEventDeletePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyEventDeleteAdapter.class);
    private final LoyaltyEventRepository loyaltyEventRepository;
    private final LoyaltyEventConfigurationRepository loyaltyEventConfigurationRepository;

    public LoyaltyEventDeleteAdapter(LoyaltyEventRepository loyaltyEventRepository, LoyaltyEventConfigurationRepository loyaltyEventConfigurationRepository) {
        this.loyaltyEventRepository = loyaltyEventRepository;
        this.loyaltyEventConfigurationRepository = loyaltyEventConfigurationRepository;
    }

    @Override
    public void deleteLoyaltyEventById(UUID id) {
        loyaltyEventRepository.deleteById(id);
    }

    @Override
    public void deleteLoyaltyEventConfigurationById(UUID id) {
        loyaltyEventConfigurationRepository.deleteById(id);
    }
}
