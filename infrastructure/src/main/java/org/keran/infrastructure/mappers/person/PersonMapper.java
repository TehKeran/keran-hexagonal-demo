package org.keran.infrastructure.mappers.person;

import org.keran.domain.data.person.PersonDto;
import org.keran.infrastructure.data.postgres.person.PersonPostgres;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source = "loyaltyCustomerPostgres.id", target = "loyaltyCustomerDto.id")
    PersonDto personPostgresToDto(PersonPostgres personPostgres);
    @Mapping(source = "loyaltyCustomerDto.id", target = "loyaltyCustomerPostgres.id")
    PersonPostgres personDtoToPostgres(PersonDto personDto);
    List<PersonDto> personPostgresListToDtoList(List<PersonPostgres> personPostgresList);
    List<PersonPostgres> personDtoListToPostgresList(List<PersonDto> personDtoList);
    static LocalDateTime map(LocalDate date) {
        if (date == null) {
            return null;
        }

        return date.atStartOfDay();
    }
    static LocalDate map(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }

        return dateTime.toLocalDate();
    }

}
