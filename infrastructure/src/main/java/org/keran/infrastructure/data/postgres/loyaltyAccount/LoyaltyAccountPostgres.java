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

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_customer_id", referencedColumnName = "id", nullable = false)
    private LoyaltyCustomerPostgres loyaltyCustomerPostgres;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_program_id",referencedColumnName = "id",  nullable = false)
    private LoyaltyProgramPostgres loyaltyProgramPostgres;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "loyalty_account_type_id", referencedColumnName = "id", nullable = false)
    private DefLoyaltyAccountTypePostgres loyaltyAccountType;

    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;

    @Column(name = "external_account_number")
    private String externalAccountNumber;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "close_date")
    private Date closeDate;
}
