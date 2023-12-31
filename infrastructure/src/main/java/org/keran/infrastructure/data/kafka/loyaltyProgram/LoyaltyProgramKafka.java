package org.keran.infrastructure.data.kafka.loyaltyProgram;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.kafka.AbstractKafkaEntity;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoyaltyProgramKafka extends AbstractKafkaEntity {
    private String name;
    private String description;
    private String imageUrl;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
