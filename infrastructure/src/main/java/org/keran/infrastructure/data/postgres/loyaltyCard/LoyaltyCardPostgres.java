package org.keran.infrastructure.data.postgres.loyaltyCard;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.postgres.AbstractPostgresEntity;
import org.keran.infrastructure.data.postgres.definitions.DefLoyaltyCardTypePostgres;
import org.keran.infrastructure.data.postgres.loyaltyCustomer.LoyaltyCustomerPostgres;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@QueryEntity
@Table(name = "loyalty_card")
public class LoyaltyCardPostgres extends AbstractPostgresEntity {
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_customer_id", referencedColumnName = "id", nullable = false)
    private LoyaltyCustomerPostgres loyaltyCustomerPostgres;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_card_type_id", referencedColumnName = "id", nullable = false)
    private DefLoyaltyCardTypePostgres cardType;

    @Column(name = "card_number", unique = true, nullable = false, length = 55)
    private String cardNumber;

    @Column(name = "display_name", nullable = false, length = 55)
    private String displayName;

    @Column(name = "card_image_url", nullable = false)
    private String cardImageUrl;
}
