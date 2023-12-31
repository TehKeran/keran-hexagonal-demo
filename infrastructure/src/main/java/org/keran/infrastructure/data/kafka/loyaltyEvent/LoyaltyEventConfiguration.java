package org.keran.infrastructure.data.kafka.loyaltyEvent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.kafka.AbstractKafkaEntity;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoyaltyEventConfiguration extends AbstractKafkaEntity {
    private UUID loyaltyProgramId;
    private UUID loyaltyEventId;
    private double loyaltyPointsToAward;
}
