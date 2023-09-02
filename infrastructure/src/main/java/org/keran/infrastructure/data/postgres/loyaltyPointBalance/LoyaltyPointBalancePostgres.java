package org.keran.infrastructure.data.postgres.loyaltyPointBalance;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.postgres.AbstractPostgresEntity;
import org.keran.infrastructure.data.postgres.loyaltyAccount.LoyaltyAccountPostgres;
import org.keran.infrastructure.data.postgres.loyaltyPoint.LoyaltyPointPostgres;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@QueryEntity
@Table(name = "loyalty_point_balance")
public class LoyaltyPointBalancePostgres extends AbstractPostgresEntity {
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_account_id", referencedColumnName = "id", nullable = false)
    private LoyaltyAccountPostgres loyaltyAccountPostgres;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_point_id", referencedColumnName = "id", nullable = false)
    private LoyaltyPointPostgres loyaltyPointPostgres;

    @Column(name = "balance", nullable = false)
    private int balance;
}
