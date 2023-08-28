package org.keran.infrastructure.data.postgres.loyaltyCustomer;


import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.postgres.AbstractPostgresEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@QueryEntity
@Table(name = "loyalty_customer")
public class LoyaltyCustomerPostgres extends AbstractPostgresEntity {
    @Column(name= "customer_number", length = 55, unique = true, nullable = false)
    private String customerNumber;

    @Column(name= "registration_date", nullable = false)
    private LocalDateTime registrationDate;


}
