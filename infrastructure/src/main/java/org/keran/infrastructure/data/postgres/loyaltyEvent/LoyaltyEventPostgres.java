package org.keran.infrastructure.data.postgres.loyaltyEvent;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.postgres.AbstractPostgresEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@QueryEntity
@Table(name = "loyalty_event")
public class LoyaltyEventPostgres extends AbstractPostgresEntity {
    @Column(name = "name", unique = true, nullable = false)
    private String name;
}
