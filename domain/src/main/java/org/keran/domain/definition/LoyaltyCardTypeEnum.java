package org.keran.domain.definition;

import lombok.Getter;

import java.util.Optional;

@Getter
public enum LoyaltyCardTypeEnum {
    L1_STANDARD("L1_STANDARD"),
    L2_PREMIUM("L2_PREMIUM"),
    L3_VIP("L3_VIP");

    private final String name;
    LoyaltyCardTypeEnum(String name) { this.name = name; }

    public static LoyaltyCardTypeEnum findByName(String name) {
        String trimmedName = Optional.ofNullable(name)
                .map(String::trim)
                .map(String::toUpperCase)
                .orElse("");
        return LoyaltyCardTypeEnum.valueOf(trimmedName);
    }

}
