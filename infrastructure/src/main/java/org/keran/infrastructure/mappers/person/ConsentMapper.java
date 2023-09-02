package org.keran.infrastructure.mappers.person;

import org.keran.domain.data.person.ConsentDto;
import org.keran.infrastructure.data.postgres.person.ConsentPostgres;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ConsentMapper {
    ConsentMapper INSTANCE = Mappers.getMapper(ConsentMapper.class);

    ConsentDto consentPostgresToDto(ConsentPostgres consentPostgres);
    ConsentPostgres consentDtoToPostgres(ConsentDto consentDto);
    List<ConsentDto> consentPostgresListToDtoList(List<ConsentPostgres> consentPostgresList);
    List<ConsentPostgres> consentDtoListToPostgresList(List<ConsentDto> consentDtoList);
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
