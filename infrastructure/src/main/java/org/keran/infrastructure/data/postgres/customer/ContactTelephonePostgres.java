package org.keran.infrastructure.data.postgres.customer;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.postgres.AbstractPostgresEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@QueryEntity
@Table(name = "contact_telephone")
public class ContactTelephonePostgres extends AbstractPostgresEntity {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    private PersonPostgres personPostgres;

    @Column(name = "country_code", length = 20, nullable = false)
    private String countryCode;

    @Column(name = "telephone_number", length = 20, nullable = false)
    private String telephoneNumber;

    @Column(name = "is_primary_telephone_number", nullable = false)
    private boolean isPrimaryTelephoneNumber;
}
