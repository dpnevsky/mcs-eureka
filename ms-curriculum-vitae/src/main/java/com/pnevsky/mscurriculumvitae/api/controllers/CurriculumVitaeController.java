package com.pnevsky.mscurriculumvitae.api.controllers;

import com.pnevsky.mscurriculumvitae.client.CountryServiceClient;
import com.pnevsky.mscurriculumvitae.model.CurriculumVitae;
import com.pnevsky.mscurriculumvitae.usecasse.CurriculumVitaeService;
import com.pnevsky.mscurriculumvitae.usecasse.dto.CurriculumVitaeDto;
import com.pnevsky.mscurriculumvitae.usecasse.mapper.CurriculumVitaeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cv")
public class CurriculumVitaeController {

    private final CurriculumVitaeService curriculumVitaeService;
    private final CurriculumVitaeMapper curriculumVitaeMapper;
    private final CountryServiceClient countryServiceClient;

    @GetMapping("/{id}")
    public ResponseEntity<CurriculumVitaeDto> getCvOfUser(@PathVariable Long id) {

        CurriculumVitae curriculumVitae = curriculumVitaeService.getCvById(id);

        if(curriculumVitae == null){
            return ResponseEntity.noContent().build();
        }

        String countryName = countryServiceClient.fetchCountryName(curriculumVitae.getCountryId());
        CurriculumVitaeDto response = curriculumVitaeMapper.fromEntityToDto(curriculumVitae);
        response.setCountryName(countryName);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CurriculumVitaeDto> save(@RequestBody CurriculumVitaeDto curriculumVitaeDto) {

        Long countryId = countryServiceClient.fetchCountryId(curriculumVitaeDto.getCountryName());
        CurriculumVitae curriculumVitae = curriculumVitaeMapper.fromDtoToEntity(curriculumVitaeDto);
        curriculumVitae.setCountryId(countryId);


        curriculumVitaeService.save(curriculumVitae);

        return new ResponseEntity<>(curriculumVitaeDto, HttpStatus.CREATED);
    }
}
