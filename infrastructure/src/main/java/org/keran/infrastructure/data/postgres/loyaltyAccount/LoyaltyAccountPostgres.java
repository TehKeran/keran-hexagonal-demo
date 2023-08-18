package org.keran.infrastructure.data.postgres.loyaltyAccount;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.infrastructure.data.postgres.AbstractPostgresEntity;
import org.keran.infrastructure.data.postgres.loyaltyCustomer.LoyaltyCustomerPostgres;
import org.keran.infrastructure.data.postgres.definitions.DefLoyaltyAccountTypePostgres;
import org.keran.infrastructure.data.postgres.loyaltyProgram.LoyaltyProgramPostgres;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@QueryEntity
@Table(name = "loyalty_account")
public class LoyaltyAccountPostgres extends AbstractPostgresEntity {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_customer_id", referencedColumnName = "id", nullable = false)
    private LoyaltyCustomerPostgres loyaltyCustomerPostgres;

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
