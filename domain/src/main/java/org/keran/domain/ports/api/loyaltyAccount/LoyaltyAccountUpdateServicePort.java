package org.keran.domain.ports.api.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;

public interface LoyaltyAccountUpdateServicePort {
    LoyaltyAccountDto updateLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto);
}
