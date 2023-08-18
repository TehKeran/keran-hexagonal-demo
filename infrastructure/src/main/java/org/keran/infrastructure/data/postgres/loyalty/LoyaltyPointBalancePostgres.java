package org.keran.infrastructure.data.postgres.loyalty;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.postgres.AbstractPostgresEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@QueryEntity
@Table(name = "loyalty_point_balance")
public class LoyaltyPointBalancePostgres extends AbstractPostgresEntity {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_account_id", referencedColumnName = "id", nullable = false)
    private LoyaltyAccountPostgres loyaltyAccountPostgres;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_point_id", referencedColumnName = "id", nullable = false)
    private LoyaltyPointPostgres loyaltyPointPostgres;

    @Column(name = "balance", nullable = false)
    private int balance;
}
