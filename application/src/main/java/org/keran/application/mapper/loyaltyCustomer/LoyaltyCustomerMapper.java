package org.keran.application.mapper.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.infrastructure.data.LoyaltyCustomerApiObject;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyCustomerMapper {
    LoyaltyCustomerMapper INSTANCE = Mappers.getMapper(LoyaltyCustomerMapper.class);

    LoyaltyCustomerDto loyaltyCustomerApiObjectToDto(LoyaltyCustomerApiObject loyaltyCustomerApiObject);
    LoyaltyCustomerApiObject loyaltyCustomerDtoToApiObject(LoyaltyCustomerDto loyaltyCustomerDto);
    List<LoyaltyCustomerDto> loyaltyCustomerApiObjectListToDtoList(List<LoyaltyCustomerApiObject> loyaltyCustomerApiObjectList);
    List<LoyaltyCustomerApiObject> loyaltyCustomerDtoListToApiObjectList(List<LoyaltyCustomerDto> loyaltyCustomerDtoList);

    default LocalDateTime map(LocalDate date) {
        return date.atStartOfDay();
    }
}
