package org.keran.infrastructure.adapters.postgres.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.domain.ports.spi.loyaltyPoint.LoyaltyPointAddPersistencePort;
import org.keran.infrastructure.adapters.postgres.loyaltyEventOccurrence.LoyaltyEventOccurrenceUpdateOccurrence;
import org.keran.infrastructure.data.postgres.loyaltyPoint.LoyaltyPointPostgres;
import org.keran.infrastructure.mappers.loyaltyPoint.LoyaltyPointMapper;
import org.keran.infrastructure.repository.loyaltyPoint.LoyaltyPointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyPointAddAdapter implements LoyaltyPointAddPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyPointAddAdapter.class);
    private final LoyaltyPointRepository loyaltyPointRepository;

    public LoyaltyPointAddAdapter(LoyaltyPointRepository loyaltyPointRepository) {
        this.loyaltyPointRepository = loyaltyPointRepository;
    }

    @Override
    public Optional<LoyaltyPointDto> addLoyaltyPoint(LoyaltyPointDto loyaltyPointDto) {
        LoyaltyPointPostgres loyaltyPointPostgres = LoyaltyPointMapper.INSTANCE.loyaltyPointDtoToPostgres(loyaltyPointDto);
        LoyaltyPointPostgres loyaltyPointPostgresCreated = loyaltyPointRepository.saveAndFlush(loyaltyPointPostgres);

        return Optional.of(LoyaltyPointMapper.INSTANCE.loyaltyPointPostgresToDto(loyaltyPointPostgresCreated));
    }
}
