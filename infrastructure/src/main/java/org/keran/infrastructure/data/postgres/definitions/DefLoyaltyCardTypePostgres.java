package org.keran.infrastructure.data.postgres.definitions;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@QueryEntity
@Table(name = "def_loyalty_card_type")
public class DefLoyaltyCardTypePostgres extends AbstractPostgresDefEntity{
}
