package org.keran.infrastructure.adapters.postgres.loyaltyAccount;

import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class LoyaltyAccountDeleteAdapter implements LoyaltyAccountDeletePersistencePort {
    @Override
    public void deleteLoyaltyAccountById(UUID id) {

    }

    @Override
    public void deleteLoyaltyAccountTransactionHistoryById(UUID id) {

    }
}
