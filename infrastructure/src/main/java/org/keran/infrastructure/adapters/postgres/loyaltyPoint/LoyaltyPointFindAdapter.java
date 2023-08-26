package org.keran.infrastructure.adapters.postgres.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.domain.ports.spi.loyaltyPoint.LoyaltyPointFindPersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyPoint.LoyaltyPointPostgres;
import org.keran.infrastructure.mappers.loyaltyPoint.LoyaltyPointMapper;
import org.keran.infrastructure.repository.loyaltyPoint.LoyaltyPointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class LoyaltyPointFindAdapter implements LoyaltyPointFindPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyPointFindAdapter.class);
    private final LoyaltyPointRepository loyaltyPointRepository;

    public LoyaltyPointFindAdapter(LoyaltyPointRepository loyaltyPointRepository) {
        this.loyaltyPointRepository = loyaltyPointRepository;
    }

    @Override
    public Optional<LoyaltyPointDto> findLoyaltyPointById(UUID id) {
        Optional<LoyaltyPointPostgres> loyaltyPointPostgres = loyaltyPointRepository.findById(id);

        return loyaltyPointPostgres.map(LoyaltyPointMapper.INSTANCE::loyaltyPointPostgresToDto);
    }

    @Override
    public Optional<LoyaltyPointDto> findLoyaltyPointByName(String name) {
        Optional<LoyaltyPointPostgres> loyaltyPointPostgres = loyaltyPointRepository.findByName(name);

        return loyaltyPointPostgres.map(LoyaltyPointMapper.INSTANCE::loyaltyPointPostgresToDto);
    }
}
