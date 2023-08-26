package org.keran.infrastructure.adapters.postgres.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.domain.ports.spi.loyaltyPoint.LoyaltyPointUpdatePersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyPoint.LoyaltyPointPostgres;
import org.keran.infrastructure.mappers.loyaltyPoint.LoyaltyPointMapper;
import org.keran.infrastructure.repository.loyaltyPoint.LoyaltyPointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyPointUpdateAdapter implements LoyaltyPointUpdatePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyPointUpdateAdapter.class);
    private final LoyaltyPointRepository loyaltyPointRepository;

    public LoyaltyPointUpdateAdapter(LoyaltyPointRepository loyaltyPointRepository) {
        this.loyaltyPointRepository = loyaltyPointRepository;
    }

    @Override
    public Optional<LoyaltyPointDto> updateLoyaltyPoint(LoyaltyPointDto loyaltyPointDto) {
        LoyaltyPointPostgres loyaltyPointPostgres = LoyaltyPointMapper.INSTANCE.loyaltyPointDtoToPostgres(loyaltyPointDto);
        LoyaltyPointPostgres loyaltyPointPostgresUpdated = loyaltyPointRepository.saveAndFlush(loyaltyPointPostgres);

        return Optional.of(LoyaltyPointMapper.INSTANCE.loyaltyPointPostgresToDto(loyaltyPointPostgresUpdated));
    }
}
