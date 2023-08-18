package org.keran.infrastructure.data.kafka.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.kafka.AbstractKafkaEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonKafka extends AbstractKafkaEntity {
    private UUID loyaltyCustomerId;
    private String salutation;
    private String firstName;
    private String middleName;
    private String firstLastName;
    private String secondLastName;
    private LocalDateTime dateOfBirth;
}
