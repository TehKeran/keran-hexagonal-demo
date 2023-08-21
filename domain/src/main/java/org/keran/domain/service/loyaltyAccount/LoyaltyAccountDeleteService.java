package org.keran.domain.service.loyaltyAccount;

import org.keran.domain.ports.api.loyaltyAccount.LoyaltyAccountDeleteServicePort;
import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyAccountDeleteService implements LoyaltyAccountDeleteServicePort {
    private final LoyaltyAccountDeletePersistencePort loyaltyAccountDeletePersistencePort;

    public LoyaltyAccountDeleteService(LoyaltyAccountDeletePersistencePort loyaltyAccountDeletePersistencePort) {
        this.loyaltyAccountDeletePersistencePort = loyaltyAccountDeletePersistencePort;
    }

    @Override
    public void deleteLoyaltyAccountById(UUID id) {
        loyaltyAccountDeletePersistencePort.deleteLoyaltyAccountById(id);
    }

    @Override
    public void deleteLoyaltyAccountTransactionHistoryById(UUID id) {
        loyaltyAccountDeletePersistencePort.deleteLoyaltyAccountTransactionHistoryById(id);
    }
}
