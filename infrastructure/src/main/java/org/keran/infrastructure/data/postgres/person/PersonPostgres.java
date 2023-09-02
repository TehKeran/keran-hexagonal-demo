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
@Table(name = "person")
public class PersonPostgres extends AbstractPostgresEntity {

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_customer_id", referencedColumnName = "id", nullable = false)
    private LoyaltyCustomerPostgres loyaltyCustomerPostgres;

    @Column(name = "salutation", length = 55, nullable = false)
    private String salutation;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "first_last_name", nullable = false)
    private String firstLastName;

    @Column(name = "second_last_name")
    private String secondLastName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDateTime dateOfBirth;
}
