package org.keran.domain.data;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class AbstractEntity {
    private UUID id;
    private Date lastModificationOn;
    private String lastModificationBy;
}
