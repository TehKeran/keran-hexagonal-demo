package org.keran.infrastructure.adapters.postgres.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.domain.ports.spi.loyaltyPointBalance.LoyaltyPointBalanceAddPersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyPointBalance.LoyaltyPointBalancePostgres;
import org.keran.infrastructure.mappers.loyaltyPointBalance.LoyaltyPointBalanceMapper;
import org.keran.infrastructure.repository.loyaltyPointBalance.LoyaltyPointBalanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyPointBalanceAddAdapter implements LoyaltyPointBalanceAddPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyPointBalanceAddAdapter.class);
    private final LoyaltyPointBalanceRepository loyaltyPointBalanceRepository;

    public LoyaltyPointBalanceAddAdapter(LoyaltyPointBalanceRepository loyaltyPointBalanceRepository) {
        this.loyaltyPointBalanceRepository = loyaltyPointBalanceRepository;
    }

    @Override
    public Optional<LoyaltyPointBalanceDto> addLoyaltyPointBalance(LoyaltyPointBalanceDto loyaltyPointBalanceDto) {
        LoyaltyPointBalancePostgres loyaltyPointBalancePostgres =
                LoyaltyPointBalanceMapper.INSTANCE.loyaltyPointBalanceDtoToPostgres(loyaltyPointBalanceDto);
        LoyaltyPointBalancePostgres loyaltyPointBalancePostgresCreated =
                loyaltyPointBalanceRepository.saveAndFlush(loyaltyPointBalancePostgres);

        return Optional.of(LoyaltyPointBalanceMapper.INSTANCE.loyaltyPointBalancePostgresToDto(loyaltyPointBalancePostgresCreated));
    }
}
