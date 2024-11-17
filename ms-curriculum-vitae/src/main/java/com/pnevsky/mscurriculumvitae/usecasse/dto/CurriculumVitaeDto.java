package com.pnevsky.mscurriculumvitae.usecasse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurriculumVitaeDto {

    private UUID uuid;

    private String name;

    private String surname;

    private String countryName;

    private String city;

    private Boolean isReadyToRelocate;

    private Boolean isReadyForRemoteWork;

    private String status;
}
