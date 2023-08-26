package org.keran.infrastructure.adapters.postgres.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.domain.ports.spi.loyaltyPointBalance.LoyaltyPointBalanceUpdatePersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyPointBalance.LoyaltyPointBalancePostgres;
import org.keran.infrastructure.mappers.loyaltyPointBalance.LoyaltyPointBalanceMapper;
import org.keran.infrastructure.repository.loyaltyPointBalance.LoyaltyPointBalanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyPointBalanceUpdateAdapter implements LoyaltyPointBalanceUpdatePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyPointBalanceUpdateAdapter.class);
    private final LoyaltyPointBalanceRepository loyaltyPointBalanceRepository;

    public LoyaltyPointBalanceUpdateAdapter(LoyaltyPointBalanceRepository loyaltyPointBalanceRepository) {
        this.loyaltyPointBalanceRepository = loyaltyPointBalanceRepository;
    }

    @Override
    public Optional<LoyaltyPointBalanceDto> updateLoyaltyPointBalance(LoyaltyPointBalanceDto loyaltyPointBalanceDto) {
        LoyaltyPointBalancePostgres loyaltyPointBalancePostgres =
                LoyaltyPointBalanceMapper.INSTANCE.loyaltyPointBalanceDtoToPostgres(loyaltyPointBalanceDto);
        LoyaltyPointBalancePostgres loyaltyPointBalancePostgresUpdated =
                loyaltyPointBalanceRepository.saveAndFlush(loyaltyPointBalancePostgres);

        return Optional.of(LoyaltyPointBalanceMapper.INSTANCE.loyaltyPointBalancePostgresToDto(loyaltyPointBalancePostgresUpdated));
    }
}
