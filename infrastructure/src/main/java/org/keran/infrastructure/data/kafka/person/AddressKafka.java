package org.keran.infrastructure.data.kafka.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.kafka.AbstractKafkaEntity;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressKafka extends AbstractKafkaEntity {
    private UUID personId;
    private String countryIso3Code;
    private String region;
    private String province;
    private String city;
    private String zipCode;
    private String streetName;
    private String buildingNumber;
    private String apartmentNumber;
}
