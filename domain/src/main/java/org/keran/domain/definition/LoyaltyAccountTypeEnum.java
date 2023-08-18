package org.keran.domain.definition;

import lombok.Getter;

import java.util.Optional;

@Getter
public enum LoyaltyAccountTypeEnum {
    L1_STANDARD("L1_STANDARD"),
    L2_PREMIUM("L2_PREMIUM"),
    L3_VIP("L3_VIP");

    private final String name;
    LoyaltyAccountTypeEnum(String name) { this.name = name; }

    public static LoyaltyAccountTypeEnum findByName(String name) {
        String trimmedName = Optional.ofNullable(name)
                .map(String::trim)
                .map(String::toUpperCase)
                .orElse("");
        return LoyaltyAccountTypeEnum.valueOf(trimmedName);
    }

}
