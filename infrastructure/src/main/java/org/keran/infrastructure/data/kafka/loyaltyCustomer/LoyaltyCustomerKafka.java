package org.keran.infrastructure.data.kafka.loyaltyCustomer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.kafka.AbstractKafkaEntity;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoyaltyCustomerKafka extends AbstractKafkaEntity {
    private String customerNumber;
    private LocalDateTime registrationDate;
}
