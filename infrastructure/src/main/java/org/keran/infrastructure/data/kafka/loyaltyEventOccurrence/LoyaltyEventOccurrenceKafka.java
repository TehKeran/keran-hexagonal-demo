package org.keran.infrastructure.data.kafka.loyaltyEventOccurrence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.kafka.AbstractKafkaEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoyaltyEventOccurrenceKafka extends AbstractKafkaEntity {
    private UUID loyaltyCustomerId;
    private UUID loyaltyEventId;
    private LocalDateTime dateOfOccurrence;
    private int quantityOfOccurrence;
    private String source;
}
