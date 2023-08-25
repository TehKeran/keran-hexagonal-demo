package org.keran.infrastructure.data.postgres.definitions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.postgres.AbstractPostgresEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public class AbstractPostgresDefEntity extends AbstractPostgresEntity {
    @Column(name = "value", nullable = false)
    protected String value;
}
