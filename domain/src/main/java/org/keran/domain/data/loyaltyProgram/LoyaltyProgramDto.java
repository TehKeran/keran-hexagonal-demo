package org.keran.domain.data.loyaltyProgram;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;

import java.time.LocalDateTime;
@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyProgramDto extends AbstractEntity {
    private String name;
    private String description;
    private String imageUrl;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
