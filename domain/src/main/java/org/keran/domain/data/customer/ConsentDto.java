package org.keran.domain.data.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class ConsentDto extends AbstractEntity {
    private String consentName;
    private Boolean isGranted;
}
