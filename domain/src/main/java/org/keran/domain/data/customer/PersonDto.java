package org.keran.domain.data.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class PersonDto extends AbstractEntity {
    private CustomerDto customerDto;
    private String salutation;
    private String firstName;
    private String middleName;
    private String firstLastName;
    private String secondLastName;
    private LocalDateTime dateOfBirth;

}
