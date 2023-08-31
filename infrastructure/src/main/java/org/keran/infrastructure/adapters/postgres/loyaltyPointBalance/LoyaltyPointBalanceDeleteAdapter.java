package org.keran.infrastructure.adapters.postgres.loyaltyPointBalance;

import org.keran.domain.ports.spi.loyaltyPointBalance.LoyaltyPointBalanceDeletePersistencePort;
import org.keran.infrastructure.repository.loyaltyPointBalance.LoyaltyPointBalanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class LoyaltyPointBalanceDeleteAdapter implements LoyaltyPointBalanceDeletePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyPointBalanceDeleteAdapter.class);
    private final LoyaltyPointBalanceRepository loyaltyPointBalanceRepository;

    public LoyaltyPointBalanceDeleteAdapter(LoyaltyPointBalanceRepository loyaltyPointBalanceRepository) {
        this.loyaltyPointBalanceRepository = loyaltyPointBalanceRepository;
    }

    @Override
    public void deleteLoyaltyPointBalanceById(UUID id) {
        loyaltyPointBalanceRepository.deleteById(id);
    }

    @Override
    public void deleteAllLoyaltyPointBalanceByLoyaltyAccountId(UUID loyaltyAccountId) {
        loyaltyPointBalanceRepository.deleteAllLoyaltyPointBalanceByLoyaltyAccountPostgres_Id(loyaltyAccountId);
    }
}
