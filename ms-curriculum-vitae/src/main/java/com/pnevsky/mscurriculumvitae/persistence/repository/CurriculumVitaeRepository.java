package com.pnevsky.mscurriculumvitae.persistence.repository;

import com.pnevsky.mscurriculumvitae.model.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumVitaeRepository extends JpaRepository<CurriculumVitae, Long> {}