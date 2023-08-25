package org.keran.infrastructure.mappers.person;

import org.keran.domain.data.person.AddressDto;
import org.keran.infrastructure.data.postgres.person.AddressPostgres;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDto addressPostgresToDto(AddressPostgres addressPostgres);
    AddressPostgres addressDtoToPostgres(AddressDto addressDto);
    List<AddressDto> addressPostgresListToDtoList(List<AddressPostgres> addressPostgresList);
    List<AddressPostgres> addressDtoListToPostgresList(List<AddressDto> addressDtoList);
}
