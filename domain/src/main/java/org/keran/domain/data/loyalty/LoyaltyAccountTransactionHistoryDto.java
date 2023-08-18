package org.keran.domain.data.loyalty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyAccountTransactionHistoryDto extends AbstractEntity {
    private LoyaltyAccountDto loyaltyAccountDto;
    private LocalDateTime dateOfTransaction;
    private double previousBalance;
    private double amount;
    private double newBalance;
    private String comment;
}
