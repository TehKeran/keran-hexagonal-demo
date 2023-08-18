package org.keran.domain.data.loyalty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;

import java.time.LocalDateTime;
@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyProgramDto extends AbstractEntity {
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
