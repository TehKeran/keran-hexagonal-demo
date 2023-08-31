package org.keran.domain.service.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;
import org.keran.domain.ports.api.loyaltyAccount.LoyaltyAccountAddServicePort;
import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountAddPersistencePort;
import org.keran.domain.validator.loyaltyAccount.LoyaltyAccountValidator;
import org.keran.domain.validator.loyaltyCustomer.LoyaltyCustomerValidator;
import org.keran.domain.validator.loyaltyProgram.LoyaltyProgramValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyAccountAddService implements LoyaltyAccountAddServicePort {
    private final LoyaltyAccountAddPersistencePort loyaltyAccountAddPersistencePort;
    private final LoyaltyAccountValidator loyaltyAccountValidator;
    private final LoyaltyCustomerValidator loyaltyCustomerValidator;
    private final LoyaltyProgramValidator loyaltyProgramValidator;

    public LoyaltyAccountAddService(LoyaltyAccountAddPersistencePort loyaltyAccountAddPersistencePort, LoyaltyAccountValidator loyaltyAccountValidator, LoyaltyCustomerValidator loyaltyCustomerValidator, LoyaltyProgramValidator loyaltyProgramValidator) {
        this.loyaltyAccountAddPersistencePort = loyaltyAccountAddPersistencePort;
        this.loyaltyAccountValidator = loyaltyAccountValidator;
        this.loyaltyCustomerValidator = loyaltyCustomerValidator;
        this.loyaltyProgramValidator = loyaltyProgramValidator;
    }

    @Override
    public Optional<LoyaltyAccountDto> addLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto) {
        // Business validation:
        // - If ID is provided - Loyalty account doesn't exist by ID
        if (loyaltyAccountDto.getId() != null) {
            loyaltyAccountValidator.validateLoyaltyAccountNotExists(loyaltyAccountDto.getLoyaltyCustomerDto().getId());
        }
        // - Loyalty account doesn't exist by number
        loyaltyAccountValidator.validateLoyaltyAccountNotExistsByAccountNumber(loyaltyAccountDto.getAccountNumber());
        // - Customer exists
        loyaltyCustomerValidator.validateLoyaltyCustomerExists(loyaltyAccountDto.getLoyaltyCustomerDto().getId());
        // - Program exists
        loyaltyProgramValidator.validateLoyaltyProgramExists(loyaltyAccountDto.getLoyaltyProgramDto().getId());

        return loyaltyAccountAddPersistencePort.addLoyaltyAccount(loyaltyAccountDto);
    }

    @Override
    public Optional<LoyaltyAccountTransactionHistoryDto> addLoyaltyAccountTransactionHistory(LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryDto) {
        return loyaltyAccountAddPersistencePort.addLoyaltyAccountTransactionHistory(loyaltyAccountTransactionHistoryDto);
    }
}
