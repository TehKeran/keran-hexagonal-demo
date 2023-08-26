package org.keran.domain.service.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;
import org.keran.domain.ports.api.loyaltyAccount.LoyaltyAccountAddServicePort;
import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountAddPersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyAccountAddService implements LoyaltyAccountAddServicePort {
    private final LoyaltyAccountAddPersistencePort loyaltyAccountAddPersistencePort;

    public LoyaltyAccountAddService(LoyaltyAccountAddPersistencePort loyaltyAccountAddPersistencePort) {
        this.loyaltyAccountAddPersistencePort = loyaltyAccountAddPersistencePort;
    }

    @Override
    public Optional<LoyaltyAccountDto> addLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto) {
        return loyaltyAccountAddPersistencePort.addLoyaltyAccount(loyaltyAccountDto);
    }

    @Override
    public Optional<LoyaltyAccountTransactionHistoryDto> addLoyaltyAccountTransactionHistory(LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryDto) {
        return loyaltyAccountAddPersistencePort.addLoyaltyAccountTransactionHistory(loyaltyAccountTransactionHistoryDto);
    }
}
