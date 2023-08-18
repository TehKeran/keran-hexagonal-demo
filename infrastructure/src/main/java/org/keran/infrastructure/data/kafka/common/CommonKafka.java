package org.keran.infrastructure.data.kafka.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonKafka {
    private Boolean wasSuccess;
    private String errorMessage;
    private LocalDateTime publishDate;
}
