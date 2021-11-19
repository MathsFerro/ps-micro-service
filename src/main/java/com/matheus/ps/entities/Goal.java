package com.matheus.ps.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.matheus.ps.dto.GoalDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String version;
    @Column(name = "organization_name")
    private String organizationName;
    @Column(columnDefinition = "TEXT", name = "organization_goal")
    private String organizationGoal;
    private String country;
    @Column(columnDefinition = "TEXT")
    private String countryGoal;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "ods_id")
    private Ods ods;

    public Goal(GoalDTO dto) {
        this.id = dto.getId();
        this.version = dto.getVersion();
        this.organizationName = dto.getOrganizationName();
        this.organizationGoal = dto.getOrganizationGoal();
        this.country = dto.getCountry();
        this.countryGoal = dto.getCountryGoal();
        this.createdAt = dto.getCreatedAt();
        this.ods = new Ods(dto.getOdsDTO());
    }

}
