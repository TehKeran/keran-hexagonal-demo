package org.keran.infrastructure.adapters.postgres.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.domain.ports.spi.loyaltyPointBalance.LoyaltyPointBalanceFindPersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyPointBalance.LoyaltyPointBalancePostgres;
import org.keran.infrastructure.mappers.loyaltyPointBalance.LoyaltyPointBalanceMapper;
import org.keran.infrastructure.repository.loyaltyPointBalance.LoyaltyPointBalanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class LoyaltyPointBalanceFindAdapter implements LoyaltyPointBalanceFindPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyPointBalanceFindAdapter.class);
    private final LoyaltyPointBalanceRepository loyaltyPointBalanceRepository;

    public LoyaltyPointBalanceFindAdapter(LoyaltyPointBalanceRepository loyaltyPointBalanceRepository) {
        this.loyaltyPointBalanceRepository = loyaltyPointBalanceRepository;
    }

    @Override
    public Optional<LoyaltyPointBalanceDto> findLoyaltyPointBalanceById(UUID id) {
        Optional<LoyaltyPointBalancePostgres> loyaltyPointBalancePostgres =
                loyaltyPointBalanceRepository.findById(id);
        return loyaltyPointBalancePostgres.map(LoyaltyPointBalanceMapper.INSTANCE::loyaltyPointBalancePostgresToDto);
    }

    @Override
    public List<LoyaltyPointBalanceDto> findLoyaltyPointBalancesByAccountId(UUID accountId) {
        List<LoyaltyPointBalancePostgres> loyaltyPointBalancePostgresList =
                loyaltyPointBalanceRepository.findAllByLoyaltyAccountPostgres_Id(accountId);
        return LoyaltyPointBalanceMapper.INSTANCE.loyaltyPointBalancePostgresListToDtoList(loyaltyPointBalancePostgresList);
    }

    @Override
    public List<LoyaltyPointBalanceDto> findLoyaltyPointBalancesByAccountIdAndLoyaltyPointId(UUID accountId, UUID loyaltyPointId) {
        List<LoyaltyPointBalancePostgres> loyaltyPointBalancePostgresList =
                loyaltyPointBalanceRepository.findAllByLoyaltyAccountPostgres_IdAndLoyaltyPointPostgres_Id(accountId, loyaltyPointId);
        return LoyaltyPointBalanceMapper.INSTANCE.loyaltyPointBalancePostgresListToDtoList(loyaltyPointBalancePostgresList);
    }
}
