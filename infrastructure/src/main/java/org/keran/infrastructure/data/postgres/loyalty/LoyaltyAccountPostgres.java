package org.keran.infrastructure.data.postgres.loyalty;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.postgres.AbstractPostgresEntity;
import org.keran.infrastructure.data.postgres.customer.CustomerPostgres;
import org.keran.infrastructure.data.postgres.definitions.DefLoyaltyAccountTypePostgres;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@QueryEntity
@Table(name = "loyalty_account")
public class LoyaltyAccountPostgres extends AbstractPostgresEntity {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private CustomerPostgres customerPostgres;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_program_id",referencedColumnName = "id",  nullable = false)
    private LoyaltyProgramPostgres loyaltyProgramPostgres;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_type_id", referencedColumnName = "id", nullable = false)
    private DefLoyaltyAccountTypePostgres accountType;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "external_account_number", nullable = false)
    private String externalAccountNumber;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "close_date")
    private Date closeDate;
}
