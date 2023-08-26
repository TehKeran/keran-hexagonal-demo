package org.keran.domain.service.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.domain.ports.api.loyaltyCard.LoyaltyCardAddServicePort;
import org.keran.domain.ports.spi.loyaltyCard.LoyaltyCardAddPersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyCardAddService implements LoyaltyCardAddServicePort {
    private final LoyaltyCardAddPersistencePort loyaltyCardAddPersistencePort;

    public LoyaltyCardAddService(LoyaltyCardAddPersistencePort loyaltyCardAddPersistencePort) {
        this.loyaltyCardAddPersistencePort = loyaltyCardAddPersistencePort;
    }

    @Override
    public Optional<LoyaltyCardDto> addLoyaltyCard(LoyaltyCardDto loyaltyCardDto) {
        return loyaltyCardAddPersistencePort.addLoyaltyCard(loyaltyCardDto);
    }
}
