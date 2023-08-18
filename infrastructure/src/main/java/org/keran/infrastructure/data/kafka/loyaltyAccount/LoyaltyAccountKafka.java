package org.keran.infrastructure.data.kafka.loyaltyAccount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.definition.LoyaltyAccountTypeEnum;
import org.keran.infrastructure.data.kafka.AbstractKafkaEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoyaltyAccountKafka extends AbstractKafkaEntity {
    private UUID loyaltyCustomerId;
    private UUID loyaltyProgramId;
    private String accountNumber;
    private String externalAccountNumber;
    private LoyaltyAccountTypeEnum accountType;
    private LocalDateTime startDate;
    private LocalDateTime closeDate;
}
