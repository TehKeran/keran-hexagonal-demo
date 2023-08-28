package org.keran.infrastructure.adapters.postgres.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.domain.ports.spi.loyaltyCard.LoyaltyCardFindPersistencePort;
import org.keran.infrastructure.data.postgres.loyaltyCard.LoyaltyCardPostgres;
import org.keran.infrastructure.mappers.loyaltyCard.LoyaltyCardMapper;
import org.keran.infrastructure.repository.loyaltyCard.LoyaltyCardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class LoyaltyCardFindAdapter implements LoyaltyCardFindPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyCardFindAdapter.class);
    private final LoyaltyCardRepository loyaltyCardRepository;

    public LoyaltyCardFindAdapter(LoyaltyCardRepository loyaltyCardRepository) {
        this.loyaltyCardRepository = loyaltyCardRepository;
    }

    @Override
    public Optional<LoyaltyCardDto> findLoyaltyCardById(UUID id) {
        Optional<LoyaltyCardPostgres> loyaltyCardPostgres = loyaltyCardRepository.findById(id);
        return loyaltyCardPostgres.map(LoyaltyCardMapper.INSTANCE::loyaltyCardPostgresToDto);
    }

    @Override
    public Optional<LoyaltyCardDto> findLoyaltyCardByNumber(String cardNumber) {
        Optional<LoyaltyCardPostgres> loyaltyCardPostgres = loyaltyCardRepository.findByCardNumber(cardNumber);
        return loyaltyCardPostgres.map(LoyaltyCardMapper.INSTANCE::loyaltyCardPostgresToDto);
    }

    @Override
    public List<LoyaltyCardDto> getLoyaltyCardsByCustomerId(UUID customerId) {
        List<LoyaltyCardPostgres> loyaltyCardPostgresList = loyaltyCardRepository.findAllByLoyaltyCustomerPostgres_Id(customerId);
        return LoyaltyCardMapper.INSTANCE.loyaltyCardPostgresListToDtoList(loyaltyCardPostgresList);
    }
}
