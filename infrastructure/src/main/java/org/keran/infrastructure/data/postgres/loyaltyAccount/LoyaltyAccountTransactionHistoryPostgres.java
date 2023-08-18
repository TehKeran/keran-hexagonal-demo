package org.keran.infrastructure.data.postgres.loyaltyAccount;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.postgres.AbstractPostgresEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@QueryEntity
@Table(name = "loyalty_account_transaction_history")
public class LoyaltyAccountTransactionHistoryPostgres extends AbstractPostgresEntity {
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_account_id", referencedColumnName = "id", nullable = false)
    private LoyaltyAccountPostgres loyaltyAccountPostgres;

    @Column(name = "date_of_transaction", nullable = false)
    private LocalDateTime dateOfTransaction;

    @Column(name = "previous_balance", nullable = false)
    private double previousBalance;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "newBalance", nullable = false)
    private double newBalance;

    @Column(name = "comment")
    private String comment;
}
