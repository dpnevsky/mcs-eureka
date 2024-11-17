package com.pnevsky.mscurriculumvitae.usecasse.impl;

import com.pnevsky.mscurriculumvitae.model.CurriculumVitae;
import com.pnevsky.mscurriculumvitae.persistence.repository.CurriculumVitaeRepository;
import com.pnevsky.mscurriculumvitae.usecasse.CurriculumVitaeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CurriculumVitaeServiceImpl implements CurriculumVitaeService {

    private final CurriculumVitaeRepository curriculumVitaeRepository;


    @Override
    public CurriculumVitae getCvById(Long id) {

        return curriculumVitaeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(CurriculumVitae curriculumVitae) {
        curriculumVitaeRepository.save(curriculumVitae);
    }
}
