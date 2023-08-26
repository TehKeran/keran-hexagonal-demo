package org.keran.domain.service.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;
import org.keran.domain.ports.api.loyaltyAccount.LoyaltyAccountUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountUpdatePersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyAccountUpdateService implements LoyaltyAccountUpdateServicePort {
    private final LoyaltyAccountUpdatePersistencePort loyaltyAccountUpdatePersistencePort;

    public LoyaltyAccountUpdateService(LoyaltyAccountUpdatePersistencePort loyaltyAccountUpdatePersistencePort) {
        this.loyaltyAccountUpdatePersistencePort = loyaltyAccountUpdatePersistencePort;
    }

    @Override
    public Optional<LoyaltyAccountDto> updateLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto) {
        return loyaltyAccountUpdatePersistencePort.updateLoyaltyAccount(loyaltyAccountDto);
    }

    @Override
    public Optional<LoyaltyAccountTransactionHistoryDto> updateLoyaltyAccountTransactionHistory(LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryDto) {
        return loyaltyAccountUpdatePersistencePort.updateLoyaltyAccountTransactionHistory(loyaltyAccountTransactionHistoryDto);
    }
}
