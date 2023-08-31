package org.keran.infrastructure.adapters.postgres.loyaltyAccount;

import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountDeletePersistencePort;
import org.keran.infrastructure.repository.loyaltyAccount.LoyaltyAccountRepository;
import org.keran.infrastructure.repository.loyaltyAccount.LoyaltyAccountTransactionHistoryRepository;
import org.keran.infrastructure.repository.loyaltyPointBalance.LoyaltyPointBalanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class LoyaltyAccountDeleteAdapter implements LoyaltyAccountDeletePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyAccountDeleteAdapter.class);
    private final LoyaltyAccountRepository loyaltyAccountRepository;
    private final LoyaltyPointBalanceRepository loyaltyPointBalanceRepository;
    private final LoyaltyAccountTransactionHistoryRepository loyaltyAccountTransactionHistoryRepository;

    public LoyaltyAccountDeleteAdapter(LoyaltyAccountRepository loyaltyAccountRepository, LoyaltyPointBalanceRepository loyaltyPointBalanceRepository, LoyaltyAccountTransactionHistoryRepository loyaltyAccountTransactionHistoryRepository) {
        this.loyaltyAccountRepository = loyaltyAccountRepository;
        this.loyaltyPointBalanceRepository = loyaltyPointBalanceRepository;
        this.loyaltyAccountTransactionHistoryRepository = loyaltyAccountTransactionHistoryRepository;
    }

    @Override
    public void deleteLoyaltyAccountById(UUID id) {
        // Delete all point balances:
        loyaltyPointBalanceRepository.deleteAllLoyaltyPointBalanceByLoyaltyAccountPostgres_Id(id);
        // Delete all loyalty account transaction histories:
        loyaltyAccountTransactionHistoryRepository.deleteAllLoyaltyAccountTransactionHistoryByLoyaltyAccountPostgres_Id(id);

        loyaltyAccountRepository.deleteById(id);
    }

    @Override
    public void deleteLoyaltyAccountTransactionHistoryById(UUID id) {
        loyaltyAccountTransactionHistoryRepository.deleteById(id);
    }

    @Override
    public void deleteAllLoyaltyAccountTransactionHistoryByLoyaltyAccount_Id(UUID loyaltyAccountId) {
        loyaltyAccountTransactionHistoryRepository.deleteAllLoyaltyAccountTransactionHistoryByLoyaltyAccountPostgres_Id(loyaltyAccountId);
    }
}
