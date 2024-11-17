package com.pnevsky.mscurriculumvitae.usecasse;

import com.pnevsky.mscurriculumvitae.model.CurriculumVitae;

public interface CurriculumVitaeService {
    CurriculumVitae getCvById(Long id);

    void save(CurriculumVitae curriculumVitae);
}
