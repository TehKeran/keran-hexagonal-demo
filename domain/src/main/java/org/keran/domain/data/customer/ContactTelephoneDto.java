package org.keran.domain.data.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContactTelephoneDto extends AbstractEntity {
    private PersonDto personDto;
    private String countryCode;
    private String telephoneNumber;
    private boolean isPrimaryTelephoneNumber;
}
