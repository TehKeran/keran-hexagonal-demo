package org.keran.infrastructure.data.postgres.person;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.postgres.AbstractPostgresEntity;
import org.keran.infrastructure.data.postgres.loyaltyCustomer.LoyaltyCustomerPostgres;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@QueryEntity
@Table(name = "consent")
public class ConsentPostgres extends AbstractPostgresEntity {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_customer_id", referencedColumnName = "id", nullable = false)
    private LoyaltyCustomerPostgres loyaltyCustomerPostgres;

    @Column(name = "consent_name", nullable = false)
    private String consentName;

    @Column(name = "is_granted", nullable = false)
    private Boolean isGranted;

    @Column(name = "date_of_grating")
    private LocalDateTime dateOfGrating;
}
