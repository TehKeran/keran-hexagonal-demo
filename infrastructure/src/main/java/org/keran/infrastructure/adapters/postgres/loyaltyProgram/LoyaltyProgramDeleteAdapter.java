package org.keran.infrastructure.adapters.postgres.loyaltyProgram;

import org.keran.domain.ports.spi.loyaltyProgram.LoyaltyProgramDeletePersistencePort;
import org.keran.infrastructure.repository.loyaltyProgram.LoyaltyProgramRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class LoyaltyProgramDeleteAdapter implements LoyaltyProgramDeletePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyProgramDeleteAdapter.class);
    private final LoyaltyProgramRepository loyaltyProgramRepository;

    public LoyaltyProgramDeleteAdapter(LoyaltyProgramRepository loyaltyProgramRepository) {
        this.loyaltyProgramRepository = loyaltyProgramRepository;
    }

    @Override
    public void deleteLoyaltyProgramById(UUID id) {
        loyaltyProgramRepository.deleteById(id);
    }
}
