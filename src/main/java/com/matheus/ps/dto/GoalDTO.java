package com.matheus.ps.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matheus.ps.entities.Goal;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoalDTO implements Serializable {

    private Long id;
    private String version;
    private String organizationName;
    private String organizationGoal;
    private String country;
    private String countryGoal;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonBackReference
    private OdsDTO odsDTO;

    public GoalDTO(Goal entity) {
        this.id = entity.getId();
        this.version = entity.getVersion();
        this.organizationName = entity.getOrganizationName();
        this.organizationGoal = entity.getOrganizationGoal();
        this.country = entity.getCountry();
        this.countryGoal = entity.getCountryGoal();
        this.createdAt = entity.getCreatedAt();
    }

}
