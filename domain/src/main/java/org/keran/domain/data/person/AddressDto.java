package org.keran.domain.data.person;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddressDto extends AbstractEntity {
    private PersonDto personDto;
    private String countryIso3Code;
    private String region;
    private String province;
    private String city;
    private String zipCode;
    private String streetName;
    private String buildingNumber;
    private String apartmentNumber;
}
