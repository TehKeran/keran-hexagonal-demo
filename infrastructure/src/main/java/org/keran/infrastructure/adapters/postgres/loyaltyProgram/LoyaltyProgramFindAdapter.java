package org.keran.infrastructure.adapters.postgres.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;
import org.keran.domain.ports.spi.loyaltyProgram.LoyaltyProgramFindPersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyProgram.LoyaltyProgramPostgres;
import org.keran.infrastructure.mappers.loyaltyProgram.LoyaltyProgramMapper;
import org.keran.infrastructure.repository.loyaltyProgram.LoyaltyProgramRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class LoyaltyProgramFindAdapter implements LoyaltyProgramFindPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyProgramFindAdapter.class);
    private final LoyaltyProgramRepository loyaltyProgramRepository;

    public LoyaltyProgramFindAdapter(LoyaltyProgramRepository loyaltyProgramRepository) {
        this.loyaltyProgramRepository = loyaltyProgramRepository;
    }

    @Override
    public Optional<LoyaltyProgramDto> findLoyaltyProgramById(UUID id) {
        Optional<LoyaltyProgramPostgres> loyaltyProgramPostgres = loyaltyProgramRepository.findById(id);
        return loyaltyProgramPostgres.map(LoyaltyProgramMapper.INSTANCE::loyaltyProgramPostgresToDto);
    }

    @Override
    public Optional<LoyaltyProgramDto> findLoyaltyProgramByName(String name) {
        Optional<LoyaltyProgramPostgres> loyaltyProgramPostgres = loyaltyProgramRepository.findByName(name);
        return loyaltyProgramPostgres.map(LoyaltyProgramMapper.INSTANCE::loyaltyProgramPostgresToDto);
    }
}
