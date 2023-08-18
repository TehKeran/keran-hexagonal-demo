package org.keran.infrastructure.data.kafka.loyaltyCard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.definition.LoyaltyCardTypeEnum;
import org.keran.infrastructure.data.kafka.AbstractKafkaEntity;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoyaltyCardKafka extends AbstractKafkaEntity {
    private UUID loyaltyCustomerId;
    private String cardNumber;
    private String displayName;
    private String cardImageUrl;
    private LoyaltyCardTypeEnum cardType;
}
