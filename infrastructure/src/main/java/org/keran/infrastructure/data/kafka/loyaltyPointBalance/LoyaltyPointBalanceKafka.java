package org.keran.infrastructure.data.kafka.loyaltyPointBalance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.kafka.AbstractKafkaEntity;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoyaltyPointBalanceKafka extends AbstractKafkaEntity {
    private UUID loyaltyAccountId;
    private UUID loyaltyPointId;
    private int balance;
}
