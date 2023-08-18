package org.keran.infrastructure.data.postgres.loyalty;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.postgres.AbstractPostgresEntity;
import org.keran.infrastructure.data.postgres.customer.CustomerPostgres;
import org.keran.infrastructure.data.postgres.definitions.DefLoyaltyCardTypePostgres;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@QueryEntity
@Table(name = "loyalty_card")
public class LoyaltyCardPostgres extends AbstractPostgresEntity {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private CustomerPostgres customerPostgres;

    @JoinColumn(name = "card_type_id", referencedColumnName = "id", nullable = false)
    private DefLoyaltyCardTypePostgres cardType;

    @Column(name = "card_number", nullable = false, length = 55)
    private String cardNumber;

    @Column(name = "display_name", nullable = false, length = 55)
    private String displayName;

    @Column(name = "card_image_url", nullable = false)
    private String cardImageUrl;
}
