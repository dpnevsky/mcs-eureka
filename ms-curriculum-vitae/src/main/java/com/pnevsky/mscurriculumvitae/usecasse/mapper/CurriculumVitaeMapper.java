package com.pnevsky.mscurriculumvitae.usecasse.mapper;

import com.pnevsky.mscurriculumvitae.model.CurriculumVitae;
import com.pnevsky.mscurriculumvitae.usecasse.dto.CurriculumVitaeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface CurriculumVitaeMapper {

    @Mapping(target = "countryName", ignore = true)
    CurriculumVitaeDto fromEntityToDto(CurriculumVitae curriculumVitae);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "countryId", ignore = true)
    CurriculumVitae fromDtoToEntity(CurriculumVitaeDto curriculumVitaeDto);

}


