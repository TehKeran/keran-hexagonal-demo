package org.keran.infrastructure.adapters.postgres.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;
import org.keran.domain.ports.spi.loyaltyEvent.LoyaltyEventFindPersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyEvent.LoyaltyEventConfigurationPostgres;
import org.keran.infrastructure.data.postgres.loyaltyEvent.LoyaltyEventPostgres;
import org.keran.infrastructure.mappers.loyaltyEvent.LoyaltyEventConfigurationMapper;
import org.keran.infrastructure.mappers.loyaltyEvent.LoyaltyEventMapper;
import org.keran.infrastructure.repository.loyaltyEvent.LoyaltyEventConfigurationRepository;
import org.keran.infrastructure.repository.loyaltyEvent.LoyaltyEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class LoyaltyEventFindAdapter implements LoyaltyEventFindPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyEventFindAdapter.class);
    private final LoyaltyEventRepository loyaltyEventRepository;
    private final LoyaltyEventConfigurationRepository loyaltyEventConfigurationRepository;

    public LoyaltyEventFindAdapter(LoyaltyEventRepository loyaltyEventRepository, LoyaltyEventConfigurationRepository loyaltyEventConfigurationRepository) {
        this.loyaltyEventRepository = loyaltyEventRepository;
        this.loyaltyEventConfigurationRepository = loyaltyEventConfigurationRepository;
    }

    @Override
    public Optional<LoyaltyEventDto> findLoyaltyEventById(UUID id) {
        Optional<LoyaltyEventPostgres> loyaltyEventPostgres = loyaltyEventRepository.findById(id);
        return loyaltyEventPostgres.map(LoyaltyEventMapper.INSTANCE::loyaltyEventPostgresToDto);
    }

    @Override
    public Optional<LoyaltyEventDto> findLoyaltyEventByName(String name) {
        Optional<LoyaltyEventPostgres> loyaltyEventPostgres = loyaltyEventRepository.findByName(name);
        return loyaltyEventPostgres.map(LoyaltyEventMapper.INSTANCE::loyaltyEventPostgresToDto);
    }

    @Override
    public Optional<LoyaltyEventConfigurationDto> findLoyaltyEventConfigurationById(UUID id) {
        Optional<LoyaltyEventConfigurationPostgres> loyaltyEventConfigurationPostgres =
                loyaltyEventConfigurationRepository.findById(id);
        return loyaltyEventConfigurationPostgres.map(LoyaltyEventConfigurationMapper.INSTANCE::loyaltyEventConfigurationPostgresToDto);
    }

    @Override
    public List<LoyaltyEventConfigurationDto> getLoyaltyEventConfigurationsByProgramId(UUID programId) {
        List<LoyaltyEventConfigurationPostgres> loyaltyEventConfigurationPostgres =
                loyaltyEventConfigurationRepository.findAllByLoyaltyProgramPostgres_Id(programId);
        return LoyaltyEventConfigurationMapper.INSTANCE.
                loyaltyEventConfigurationPostgresListToDtoList(loyaltyEventConfigurationPostgres);
    }

    @Override
    public boolean existsById(UUID id) {
        return loyaltyEventRepository.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return loyaltyEventRepository.existsByName(name);
    }

    @Override
    public boolean existsConfigurationByEventIdAndProgramId(UUID loyaltyEventId, UUID loyaltyProgramID) {
        return loyaltyEventConfigurationRepository.existsByLoyaltyEventPostgres_IdAndLoyaltyProgramPostgres_Id(loyaltyEventId, loyaltyProgramID);
    }

    @Override
    public boolean existsConfigurationById(UUID id) {
        return loyaltyEventConfigurationRepository.existsById(id);
    }
}
