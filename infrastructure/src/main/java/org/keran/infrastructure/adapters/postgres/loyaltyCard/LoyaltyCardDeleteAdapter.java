package org.keran.infrastructure.adapters.postgres.loyaltyCard;

import org.keran.domain.ports.spi.loyaltyCard.LoyaltyCardDeletePersistencePort;
import org.keran.infrastructure.repository.loyaltyCard.LoyaltyCardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class LoyaltyCardDeleteAdapter implements LoyaltyCardDeletePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyCardDeleteAdapter.class);
    private final LoyaltyCardRepository loyaltyCardRepository;

    public LoyaltyCardDeleteAdapter(LoyaltyCardRepository loyaltyCardRepository) {
        this.loyaltyCardRepository = loyaltyCardRepository;
    }

    @Override
    public void deleteLoyaltyCardById(UUID loyaltyCardId) {
        loyaltyCardRepository.deleteById(loyaltyCardId);
    }
}
