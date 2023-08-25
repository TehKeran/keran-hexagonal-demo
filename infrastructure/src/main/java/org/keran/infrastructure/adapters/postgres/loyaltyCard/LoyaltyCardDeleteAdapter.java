package org.keran.infrastructure.adapters.postgres.loyaltyCard;

import org.keran.domain.ports.spi.loyaltyCard.LoyaltyCardDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class LoyaltyCardDeleteAdapter implements LoyaltyCardDeletePersistencePort {
    @Override
    public void deleteLoyaltyCardById(UUID loyaltyCardId) {

    }
}
