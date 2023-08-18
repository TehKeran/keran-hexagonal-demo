package org.keran.infrastructure.data.kafka.loyaltyEvent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.kafka.AbstractKafkaEntity;

import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoyaltyEventOccurrenceKafka extends AbstractKafkaEntity {
    private UUID loyaltyAccountId;
    private UUID loyaltyEventId;
    private Date dateOfOccurrence;
    private int quantityOfOccurrence;
    private String source;
}
