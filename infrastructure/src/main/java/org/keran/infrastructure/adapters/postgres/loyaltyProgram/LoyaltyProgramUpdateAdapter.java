package org.keran.infrastructure.adapters.postgres.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;
import org.keran.domain.ports.spi.loyaltyProgram.LoyaltyProgramUpdatePersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyProgram.LoyaltyProgramPostgres;
import org.keran.infrastructure.mappers.loyaltyProgram.LoyaltyProgramMapper;
import org.keran.infrastructure.repository.loyaltyProgram.LoyaltyProgramRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyProgramUpdateAdapter implements LoyaltyProgramUpdatePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyProgramUpdateAdapter.class);
    private final LoyaltyProgramRepository loyaltyProgramRepository;

    public LoyaltyProgramUpdateAdapter(LoyaltyProgramRepository loyaltyProgramRepository) {
        this.loyaltyProgramRepository = loyaltyProgramRepository;
    }

    @Override
    public Optional<LoyaltyProgramDto> updateLoyaltyProgram(LoyaltyProgramDto loyaltyProgramDto) {
        LoyaltyProgramPostgres loyaltyProgramPostgres = LoyaltyProgramMapper.INSTANCE.loyaltyProgramDtoToPostgres(loyaltyProgramDto);
        LoyaltyProgramPostgres loyaltyProgramPostgresUpdated = loyaltyProgramRepository.saveAndFlush(loyaltyProgramPostgres);

        return Optional.of(LoyaltyProgramMapper.INSTANCE.loyaltyProgramPostgresToDto(loyaltyProgramPostgresUpdated));
    }
}
