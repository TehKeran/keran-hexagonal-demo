package org.keran.infrastructure.data.kafka.loyalty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.kafka.AbstractKafkaEntity;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoyaltyProgramKafka extends AbstractKafkaEntity {
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
}
