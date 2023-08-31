package org.keran.domain.service.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;
import org.keran.domain.ports.api.loyaltyAccount.LoyaltyAccountUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountUpdatePersistencePort;
import org.keran.domain.validator.loyaltyAccount.LoyaltyAccountValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyAccountUpdateService implements LoyaltyAccountUpdateServicePort {
    private final LoyaltyAccountUpdatePersistencePort loyaltyAccountUpdatePersistencePort;
    private final LoyaltyAccountValidator loyaltyAccountValidator;

    public LoyaltyAccountUpdateService(LoyaltyAccountUpdatePersistencePort loyaltyAccountUpdatePersistencePort, LoyaltyAccountValidator loyaltyAccountValidator) {
        this.loyaltyAccountUpdatePersistencePort = loyaltyAccountUpdatePersistencePort;
        this.loyaltyAccountValidator = loyaltyAccountValidator;
    }

    @Override
    public Optional<LoyaltyAccountDto> updateLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto) {
        // Business validation
        // - Loyalty account must exist
        loyaltyAccountValidator.validateLoyaltyAccountExists(loyaltyAccountDto.getId());

        return loyaltyAccountUpdatePersistencePort.updateLoyaltyAccount(loyaltyAccountDto);
    }

    @Override
    public Optional<LoyaltyAccountTransactionHistoryDto> updateLoyaltyAccountTransactionHistory(LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryDto) {
        return loyaltyAccountUpdatePersistencePort.updateLoyaltyAccountTransactionHistory(loyaltyAccountTransactionHistoryDto);
    }
}
