package com.pnevsky.mscurriculumvitae.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cvs")
public class CurriculumVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "city")
    private String city;

    @Column(name = "is_ready_to_relocate")
    private Boolean isReadyToRelocate;

    @Column(name = "is_ready_for_remote_work")
    private Boolean isReadyForRemoteWork;

    @Column(name = "status")
    private String status;
}
