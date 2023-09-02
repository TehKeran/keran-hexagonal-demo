package org.keran.infrastructure.adapters.postgres.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.spi.loyaltyPointBalance.LoyaltyPointBalanceAddPersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyAccount.LoyaltyAccountPostgres;
import org.keran.infrastructure.data.postgres.loyaltyPoint.LoyaltyPointPostgres;
import org.keran.infrastructure.data.postgres.loyaltyPointBalance.LoyaltyPointBalancePostgres;
import org.keran.infrastructure.mappers.loyaltyPointBalance.LoyaltyPointBalanceMapper;
import org.keran.infrastructure.repository.loyaltyAccount.LoyaltyAccountRepository;
import org.keran.infrastructure.repository.loyaltyPoint.LoyaltyPointRepository;
import org.keran.infrastructure.repository.loyaltyPointBalance.LoyaltyPointBalanceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyPointBalanceAddAdapter implements LoyaltyPointBalanceAddPersistencePort {
    private final LoyaltyPointBalanceRepository loyaltyPointBalanceRepository;
    private final LoyaltyPointRepository loyaltyPointRepository;
    private final LoyaltyAccountRepository loyaltyAccountRepository;

    public LoyaltyPointBalanceAddAdapter(LoyaltyPointBalanceRepository loyaltyPointBalanceRepository, LoyaltyPointRepository loyaltyPointRepository, LoyaltyAccountRepository loyaltyAccountRepository) {
        this.loyaltyPointBalanceRepository = loyaltyPointBalanceRepository;
        this.loyaltyPointRepository = loyaltyPointRepository;
        this.loyaltyAccountRepository = loyaltyAccountRepository;
    }

    @Override
    public Optional<LoyaltyPointBalanceDto> addLoyaltyPointBalance(LoyaltyPointBalanceDto loyaltyPointBalanceDto) {
        LoyaltyPointBalancePostgres loyaltyPointBalancePostgres =
                LoyaltyPointBalanceMapper.INSTANCE.loyaltyPointBalanceDtoToPostgres(loyaltyPointBalanceDto);
        Optional<LoyaltyPointPostgres> loyaltyPointPostgres =
                loyaltyPointRepository.findById(loyaltyPointBalanceDto.getLoyaltyPointDto().getId());
        if (loyaltyPointPostgres.isEmpty()) {
            throw new EntityNotFoundException(LoyaltyPointPostgres.class.getSimpleName(),
                    loyaltyPointBalanceDto.getLoyaltyPointDto().getId().toString());
        }

        Optional<LoyaltyAccountPostgres> loyaltyAccountPostgres =
                loyaltyAccountRepository.findById(loyaltyPointBalanceDto.getLoyaltyAccountDto().getId());
        if (loyaltyAccountPostgres.isEmpty()) {
            throw new EntityNotFoundException(LoyaltyAccountPostgres.class.getSimpleName(),
                    loyaltyPointBalanceDto.getLoyaltyAccountDto().getId().toString());
        }

        loyaltyPointBalancePostgres.setLoyaltyPointPostgres(loyaltyPointPostgres.get());
        loyaltyPointBalancePostgres.setLoyaltyAccountPostgres(loyaltyAccountPostgres.get());

        LoyaltyPointBalancePostgres loyaltyPointBalancePostgresCreated =
                loyaltyPointBalanceRepository.saveAndFlush(loyaltyPointBalancePostgres);

        return Optional.of(LoyaltyPointBalanceMapper.INSTANCE.loyaltyPointBalancePostgresToDto(loyaltyPointBalancePostgresCreated));
    }
}
