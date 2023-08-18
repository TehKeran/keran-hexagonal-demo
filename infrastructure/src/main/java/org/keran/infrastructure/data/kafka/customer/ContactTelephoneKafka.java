package org.keran.infrastructure.data.kafka.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.kafka.AbstractKafkaEntity;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactTelephoneKafka extends AbstractKafkaEntity {
    private UUID personId;
    private String countryCode;
    private String telephoneNumber;
    private boolean isPrimaryTelephoneNumber;
}
