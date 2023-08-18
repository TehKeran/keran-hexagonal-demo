package org.keran.infrastructure.data.kafka.loyaltyAccount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.kafka.AbstractKafkaEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoyaltyAccountTransactionHistoryKafka extends AbstractKafkaEntity {
    private UUID loyaltyAccountId;
    private LocalDateTime dateOfTransaction;
    private double previousBalance;
    private double amount;
    private double newBalance;
    private String comment;
}
