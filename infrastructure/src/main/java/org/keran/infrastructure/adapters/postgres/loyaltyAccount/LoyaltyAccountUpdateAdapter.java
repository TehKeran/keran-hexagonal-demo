package org.keran.infrastructure.adapters.postgres.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;
import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountUpdatePersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyAccount.LoyaltyAccountPostgres;
import org.keran.infrastructure.data.postgres.loyaltyAccount.LoyaltyAccountTransactionHistoryPostgres;
import org.keran.infrastructure.mappers.loyaltyAccount.LoyaltyAccountMapper;
import org.keran.infrastructure.mappers.loyaltyAccount.LoyaltyAccountTransactionHistoryMapper;
import org.keran.infrastructure.repository.loyaltyAccount.LoyaltyAccountRepository;
import org.keran.infrastructure.repository.loyaltyAccount.LoyaltyAccountTransactionHistoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyAccountUpdateAdapter implements LoyaltyAccountUpdatePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyAccountUpdateAdapter.class);
    private final LoyaltyAccountRepository loyaltyAccountRepository;
    private final LoyaltyAccountTransactionHistoryRepository loyaltyAccountTransactionHistoryRepository;

    public LoyaltyAccountUpdateAdapter(LoyaltyAccountRepository loyaltyAccountRepository, LoyaltyAccountTransactionHistoryRepository loyaltyAccountTransactionHistoryRepository) {
        this.loyaltyAccountRepository = loyaltyAccountRepository;
        this.loyaltyAccountTransactionHistoryRepository = loyaltyAccountTransactionHistoryRepository;
    }

    @Override
    public Optional<LoyaltyAccountDto> updateLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto) {
        LoyaltyAccountPostgres loyaltyAccountPostgres = LoyaltyAccountMapper.INSTANCE.loyaltyAccountDtoToPostgres(loyaltyAccountDto);
        LoyaltyAccountPostgres loyaltyAccountPostgresUpdated = loyaltyAccountRepository.saveAndFlush(loyaltyAccountPostgres);
        return Optional.of(LoyaltyAccountMapper.INSTANCE.loyaltyAccountPostgresToDto(loyaltyAccountPostgresUpdated));
    }

    @Override
    public Optional<LoyaltyAccountTransactionHistoryDto> updateLoyaltyAccountTransactionHistory(LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryDto) {
        LoyaltyAccountTransactionHistoryPostgres loyaltyAccountTransactionHistoryPostgres =
                LoyaltyAccountTransactionHistoryMapper.INSTANCE.loyaltyAccountTransactionHistoryDtoToPostgres(loyaltyAccountTransactionHistoryDto);
        LoyaltyAccountTransactionHistoryPostgres loyaltyAccountTransactionHistoryPostgresUpdated =
                loyaltyAccountTransactionHistoryRepository.saveAndFlush(loyaltyAccountTransactionHistoryPostgres);
        return Optional.of(LoyaltyAccountTransactionHistoryMapper.INSTANCE.loyaltyAccountTransactionHistoryPostgresToDto(
                loyaltyAccountTransactionHistoryPostgresUpdated));
    }
}
