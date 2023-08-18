package org.keran.domain.data.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerDto extends AbstractEntity {
    private LocalDateTime registrationDate;
}
