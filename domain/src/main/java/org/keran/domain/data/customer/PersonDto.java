package org.keran.domain.data.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PersonDto extends AbstractEntity {
    private String salutation;
    private String firstName;
    private String middleName;
    private String firstLastName;
    private String secondLastName;
    private Date dateOfBirth;
    private List<AddressDto> addressDtoList;
    private List<ContactEmailDto> contactEmailDtoDtoList;
    private List<ContactTelephoneDto> contactTelephoneDtoDtoList;

}
