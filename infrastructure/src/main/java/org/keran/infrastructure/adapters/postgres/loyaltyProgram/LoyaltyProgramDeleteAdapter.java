package org.keran.infrastructure.adapters.postgres.loyaltyProgram;

import org.keran.domain.ports.spi.loyaltyProgram.LoyaltyProgramDeletePersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyAccount.LoyaltyAccountPostgres;
import org.keran.infrastructure.repository.loyaltyAccount.LoyaltyAccountRepository;
import org.keran.infrastructure.repository.loyaltyAccount.LoyaltyAccountTransactionHistoryRepository;
import org.keran.infrastructure.repository.loyaltyEvent.LoyaltyEventConfigurationRepository;
import org.keran.infrastructure.repository.loyaltyPointBalance.LoyaltyPointBalanceRepository;
import org.keran.infrastructure.repository.loyaltyProgram.LoyaltyProgramRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Service
public class LoyaltyProgramDeleteAdapter implements LoyaltyProgramDeletePersistencePort {
    private final LoyaltyProgramRepository loyaltyProgramRepository;
    private final LoyaltyAccountRepository loyaltyAccountRepository;
    private final LoyaltyPointBalanceRepository loyaltyPointBalanceRepository;
    private final LoyaltyAccountTransactionHistoryRepository loyaltyAccountTransactionHistoryRepository;
    private final LoyaltyEventConfigurationRepository loyaltyEventConfigurationRepository;

    public LoyaltyProgramDeleteAdapter(LoyaltyProgramRepository loyaltyProgramRepository, LoyaltyAccountRepository loyaltyAccountRepository, LoyaltyPointBalanceRepository loyaltyPointBalanceRepository, LoyaltyAccountTransactionHistoryRepository loyaltyAccountTransactionHistoryRepository, LoyaltyEventConfigurationRepository loyaltyEventConfigurationRepository) {
        this.loyaltyProgramRepository = loyaltyProgramRepository;
        this.loyaltyAccountRepository = loyaltyAccountRepository;
        this.loyaltyPointBalanceRepository = loyaltyPointBalanceRepository;
        this.loyaltyAccountTransactionHistoryRepository = loyaltyAccountTransactionHistoryRepository;
        this.loyaltyEventConfigurationRepository = loyaltyEventConfigurationRepository;
    }

    @Override
    @Transactional
    public void deleteLoyaltyProgramById(UUID id) {
        // Get all loyalty accounts
        List<LoyaltyAccountPostgres> loyaltyAccountPostgresList = loyaltyAccountRepository.findAllLoyaltyAccountsByLoyaltyProgramPostgres_Id(id);
        for (LoyaltyAccountPostgres loyaltyAccountPostgres : loyaltyAccountPostgresList) {
            UUID loyaltyAccountId = loyaltyAccountPostgres.getId();
            // Delete all point balances:
            loyaltyPointBalanceRepository.deleteAllLoyaltyPointBalanceByLoyaltyAccountPostgres_Id(loyaltyAccountId);
            // Delete all loyalty account transaction histories:
            loyaltyAccountTransactionHistoryRepository.deleteAllLoyaltyAccountTransactionHistoryByLoyaltyAccountPostgres_Id(loyaltyAccountId);
            // Delete loyalty account:
            loyaltyAccountRepository.deleteById(loyaltyAccountId);
        }

        // Delete - all event configurations
        loyaltyEventConfigurationRepository.deleteAllByLoyaltyProgramPostgres_Id(id);

        loyaltyProgramRepository.deleteById(id);
    }
}
