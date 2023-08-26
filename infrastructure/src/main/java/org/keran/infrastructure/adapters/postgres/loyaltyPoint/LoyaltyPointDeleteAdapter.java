package org.keran.infrastructure.adapters.postgres.loyaltyPoint;

import org.keran.domain.ports.spi.loyaltyPoint.LoyaltyPointDeletePersistencePort;
import org.keran.infrastructure.repository.loyaltyPoint.LoyaltyPointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class LoyaltyPointDeleteAdapter implements LoyaltyPointDeletePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyPointDeleteAdapter.class);
    private final LoyaltyPointRepository loyaltyPointRepository;

    public LoyaltyPointDeleteAdapter(LoyaltyPointRepository loyaltyPointRepository) {
        this.loyaltyPointRepository = loyaltyPointRepository;
    }

    @Override
    public void deleteLoyaltyPointById(UUID id) {
        loyaltyPointRepository.deleteById(id);
    }
}
