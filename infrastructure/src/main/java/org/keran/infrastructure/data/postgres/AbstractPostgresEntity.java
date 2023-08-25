package org.keran.infrastructure.data.postgres;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Nationalized;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode
@MappedSuperclass
@Data
public class AbstractPostgresEntity {
    @Id
    @Column(name = "id", updatable = false, columnDefinition = "CHAR(36)")
    protected UUID id;

    @CreatedBy
    @ReadOnlyProperty
    @Nationalized
    @Column(name = "last_modification_by")
    protected String lastModificationBy;

    @CreatedDate
    @ReadOnlyProperty
    @Column(name = "last_modification_on")
    protected LocalDateTime lastModificationOn;
}
