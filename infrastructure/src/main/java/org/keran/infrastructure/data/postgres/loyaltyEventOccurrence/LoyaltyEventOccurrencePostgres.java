package org.keran.infrastructure.data.postgres.loyaltyEventOccurrence;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.postgres.AbstractPostgresEntity;
import org.keran.infrastructure.data.postgres.loyaltyAccount.LoyaltyAccountPostgres;
import org.keran.infrastructure.data.postgres.loyaltyEvent.LoyaltyEventPostgres;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@QueryEntity
@Table(name = "loyalty_event_occurrence")
public class LoyaltyEventOccurrencePostgres extends AbstractPostgresEntity {
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_account_id", referencedColumnName = "id", nullable = false)
    private LoyaltyAccountPostgres loyaltyAccountPostgres;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_event_id", referencedColumnName = "id", nullable = false)
    private LoyaltyEventPostgres loyaltyEventPostgres;

    @Column(name = "date_of_occurrence")
    private Date dateOfOccurrence;

    @Column(name = "quantity_of_occurrence")
    private int quantityOfOccurrence;

    @Column(name = "source")
    private String source;
}
