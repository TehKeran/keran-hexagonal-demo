package org.keran.domain.data.person;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;
import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class PersonDto extends AbstractEntity {
    private LoyaltyCustomerDto loyaltyCustomerDto;
    private String salutation;
    private String firstName;
    private String middleName;
    private String firstLastName;
    private String secondLastName;
    private LocalDateTime dateOfBirth;

}
