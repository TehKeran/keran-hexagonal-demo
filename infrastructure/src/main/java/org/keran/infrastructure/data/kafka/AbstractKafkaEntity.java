package org.keran.infrastructure.data.kafka;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.keran.infrastructure.data.kafka.common.CommonKafka;

import javax.persistence.MappedSuperclass;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@MappedSuperclass
public class AbstractKafkaEntity {
    private CommonKafka commonKafka;
}
