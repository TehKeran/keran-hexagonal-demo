package org.keran.infrastructure.data.postgres.customer;


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
@Table(name = "customer")
public class CustomerPostgres extends AbstractPostgresEntity {

    @Column(name= "registration_date", nullable = false)
    private LocalDateTime registrationDate;


}
