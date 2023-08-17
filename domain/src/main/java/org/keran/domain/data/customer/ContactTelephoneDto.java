package org.keran.domain.data.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContactTelephoneDto extends AbstractEntity {
    private String telephoneNumberCountryCode;
    private String telephoneNumber;
    private boolean isPrimaryTelephoneNumber;
}
