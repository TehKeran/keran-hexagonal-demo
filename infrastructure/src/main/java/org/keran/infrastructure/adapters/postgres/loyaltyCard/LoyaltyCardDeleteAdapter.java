package org.keran.infrastructure.adapters.postgres.loyaltyCard;

import org.keran.domain.ports.spi.loyaltyCard.LoyaltyCardDeletePersistencePort;

import java.util.UUID;

public class LoyaltyCardDeleteAdapter implements LoyaltyCardDeletePersistencePort {
    @Override
    public void deleteLoyaltyCardById(UUID loyaltyCardId) {

    }
}
