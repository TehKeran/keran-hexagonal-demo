package org.keran.domain.data.person;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContactEmailDto extends AbstractEntity {
    private PersonDto personDto;
    private String emailAddress;
    private boolean isPrimaryEmail;
}
