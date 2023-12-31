package org.keran.infrastructure.data.postgres.loyaltyEvent;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.postgres.AbstractPostgresEntity;
import org.keran.infrastructure.data.postgres.loyaltyProgram.LoyaltyProgramPostgres;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@QueryEntity
@Table(name = "loyalty_event_configuration")
public class LoyaltyEventConfigurationPostgres extends AbstractPostgresEntity {
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_program_id", referencedColumnName = "id", nullable = false)
    private LoyaltyProgramPostgres loyaltyProgramPostgres;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_event_id", referencedColumnName = "id", nullable = false)
    private LoyaltyEventPostgres loyaltyEventPostgres;

    @Column(name = "loyalty_points_to_award",  nullable = false)
    private int loyaltyPointsToAward;
}
