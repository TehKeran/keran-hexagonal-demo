package org.keran.infrastructure.adapters.postgres.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.domain.ports.spi.loyaltyCard.LoyaltyCardUpdatePersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyCard.LoyaltyCardPostgres;
import org.keran.infrastructure.mappers.loyaltyCard.LoyaltyCardMapper;
import org.keran.infrastructure.repository.loyaltyCard.LoyaltyCardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyCardUpdateAdapter implements LoyaltyCardUpdatePersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyCardUpdateAdapter.class);
    private final LoyaltyCardRepository loyaltyCardRepository;

    public LoyaltyCardUpdateAdapter(LoyaltyCardRepository loyaltyCardRepository) {
        this.loyaltyCardRepository = loyaltyCardRepository;
    }

    @Override
    public Optional<LoyaltyCardDto> updateLoyaltyCard(LoyaltyCardDto loyaltyCardDto) {
        LoyaltyCardPostgres loyaltyCardPostgres = LoyaltyCardMapper.INSTANCE.loyaltyCardDtoToPostgres(loyaltyCardDto);
        LoyaltyCardPostgres loyaltyCardPostgresUpdated = loyaltyCardRepository.saveAndFlush(loyaltyCardPostgres);

        return Optional.of(LoyaltyCardMapper.INSTANCE.loyaltyCardPostgresToDto(loyaltyCardPostgresUpdated));

    }
}
