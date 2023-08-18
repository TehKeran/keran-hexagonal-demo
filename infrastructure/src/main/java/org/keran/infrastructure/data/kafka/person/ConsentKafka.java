package org.keran.infrastructure.data.kafka.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.kafka.AbstractKafkaEntity;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsentKafka extends AbstractKafkaEntity {
    private UUID loyaltyCustomerId;
    private String consentName;
    private Boolean isGranted;
}
