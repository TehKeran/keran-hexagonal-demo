package org.keran.infrastructure.data.postgres;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode
@MappedSuperclass
@Data
public class AbstractPostgresEntity {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
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
