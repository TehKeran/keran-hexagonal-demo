package org.keran.infrastructure.data.postgres.person;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.postgres.AbstractPostgresEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@QueryEntity
@Table(name = "contact_email")
public class ContactEmailPostgres extends AbstractPostgresEntity {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    private PersonPostgres personPostgres;

    @Column(name = "email_address", length = 20, unique = true, nullable = false)
    private String emailAddress;

    @Column(name = "is_primary_email", nullable = false)
    private boolean isPrimaryEmail;
}
