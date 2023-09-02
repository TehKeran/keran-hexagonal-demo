package org.keran.infrastructure.utility;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.domain.definition.LoyaltyAccountTypeEnum;
import org.keran.domain.definition.LoyaltyCardTypeEnum;
import org.keran.domain.exception.common.EntityNotFoundException;

import java.util.UUID;

public class DefIdsUtility {
    private DefIdsUtility() {}
    public static UUID findDefLoyaltyCardTypeId(LoyaltyCardTypeEnum loyaltyCardTypeEnum) {
        switch (loyaltyCardTypeEnum) {
            case L1_STANDARD -> {
                return UUID.fromString("e9b89d1b-348b-48f5-af2b-dfece94d0d3c");
            }
            case L2_PREMIUM -> {
                return UUID.fromString("5cae9355-32f8-488e-bf09-5ce8b091aa39");
            }
            case L3_VIP -> {
                return UUID.fromString("e214923f-1d4d-4720-9ab4-6b56d656a601");
            }
            default ->
                throw new EntityNotFoundException(LoyaltyCardDto.class.getSimpleName(), "loyaltyCardTypeEnum");
        }
    }
    public static UUID findDefAccountTypeId(LoyaltyAccountTypeEnum loyaltyAccountTypeEnum) {
        switch (loyaltyAccountTypeEnum) {
            case L1_STANDARD -> {
                return UUID.fromString("ad90a5ec-b7f9-4673-9bb9-1f086b20fc23");
            }
            case L2_PREMIUM -> {
                return UUID.fromString("29dfe007-f1f7-4ae6-8d9c-decf118117b5");
            }
            case L3_VIP -> {
                return UUID.fromString("0b016bf7-2a1c-418d-a32f-99d3c3b34552");
            }
            default ->
                    throw new EntityNotFoundException(LoyaltyCardDto.class.getSimpleName(), "loyaltyAccountTypeEnum");
        }
    }
}
