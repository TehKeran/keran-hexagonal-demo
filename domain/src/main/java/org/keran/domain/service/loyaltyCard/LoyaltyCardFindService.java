package org.keran.domain.service.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.domain.ports.api.loyaltyCard.LoyaltyCardFindServicePort;
import org.keran.domain.ports.spi.loyaltyCard.LoyaltyCardFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class LoyaltyCardFindService implements LoyaltyCardFindServicePort {
    private final LoyaltyCardFindPersistencePort loyaltyCardFindPersistencePort;

    public LoyaltyCardFindService(LoyaltyCardFindPersistencePort loyaltyCardFindPersistencePort) {
        this.loyaltyCardFindPersistencePort = loyaltyCardFindPersistencePort;
    }

    @Override
    public Optional<LoyaltyCardDto> findLoyaltyCardById(UUID id) {
        return loyaltyCardFindPersistencePort.findLoyaltyCardById(id);
    }

    @Override
    public Optional<LoyaltyCardDto> findLoyaltyCardByNumber(String cardNumber) {
        return loyaltyCardFindPersistencePort.findLoyaltyCardByNumber(cardNumber);
    }

    @Override
    public List<LoyaltyCardDto> getLoyaltyCardsByCustomerId(UUID customerId) {
        return loyaltyCardFindPersistencePort.getLoyaltyCardsByCustomerId(customerId);
    }
}
