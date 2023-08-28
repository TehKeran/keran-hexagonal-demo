package org.keran.infrastructure.adapters.postgres.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;
import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountFindPersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyAccount.LoyaltyAccountPostgres;
import org.keran.infrastructure.data.postgres.loyaltyAccount.LoyaltyAccountTransactionHistoryPostgres;
import org.keran.infrastructure.mappers.loyaltyAccount.LoyaltyAccountMapper;
import org.keran.infrastructure.mappers.loyaltyAccount.LoyaltyAccountTransactionHistoryMapper;
import org.keran.infrastructure.repository.loyaltyAccount.LoyaltyAccountRepository;
import org.keran.infrastructure.repository.loyaltyAccount.LoyaltyAccountTransactionHistoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class LoyaltyAccountFindAdapter implements LoyaltyAccountFindPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyAccountFindAdapter.class);
    private final LoyaltyAccountRepository loyaltyAccountRepository;
    private final LoyaltyAccountTransactionHistoryRepository loyaltyAccountTransactionHistoryRepository;

    public LoyaltyAccountFindAdapter(LoyaltyAccountRepository loyaltyAccountRepository,
                                     LoyaltyAccountTransactionHistoryRepository loyaltyAccountTransactionHistoryRepository) {
        this.loyaltyAccountRepository = loyaltyAccountRepository;
        this.loyaltyAccountTransactionHistoryRepository = loyaltyAccountTransactionHistoryRepository;
    }

    @Override
    public Optional<LoyaltyAccountDto> findLoyaltyAccountById(UUID id) {
        Optional<LoyaltyAccountPostgres> loyaltyAccountPostgres = loyaltyAccountRepository.findById(id);
        return loyaltyAccountPostgres.map(LoyaltyAccountMapper.INSTANCE::loyaltyAccountPostgresToDto);
    }

    @Override
    public Optional<LoyaltyAccountDto> findLoyaltyAccountByNumber(String accountNumber) {
        Optional<LoyaltyAccountPostgres> loyaltyAccountPostgres = loyaltyAccountRepository.findByAccountNumber(accountNumber);
        return loyaltyAccountPostgres.map(LoyaltyAccountMapper.INSTANCE::loyaltyAccountPostgresToDto);
    }

    @Override
    public Optional<LoyaltyAccountTransactionHistoryDto> findLoyaltyAccountTransactionHistoryById(UUID id) {
        Optional<LoyaltyAccountTransactionHistoryPostgres> loyaltyAccountTransactionHistoryPostgres =
                loyaltyAccountTransactionHistoryRepository.findById(id);
        return loyaltyAccountTransactionHistoryPostgres.map(LoyaltyAccountTransactionHistoryMapper.
                INSTANCE::loyaltyAccountTransactionHistoryPostgresToDto);
    }

    @Override
    public List<LoyaltyAccountTransactionHistoryDto> getLoyaltyAccountTransactionHistoryByAccountId(UUID accountId) {
        List<LoyaltyAccountTransactionHistoryPostgres> loyaltyAccountTransactionHistoryPostgresList =
                loyaltyAccountTransactionHistoryRepository.findAllByLoyaltyAccountPostgres_Id(accountId);
        return LoyaltyAccountTransactionHistoryMapper.INSTANCE.loyaltyAccountTransactionHistoryPostgresListToDtoList(
                loyaltyAccountTransactionHistoryPostgresList);
    }

    @Override
    public boolean existsLoyaltyAccountById(UUID accountId) {
        return loyaltyAccountTransactionHistoryRepository.existsByLoyaltyAccountPostgres_Id(accountId);
    }
}
