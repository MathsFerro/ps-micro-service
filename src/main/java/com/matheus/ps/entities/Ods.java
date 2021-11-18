package com.matheus.ps.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.matheus.ps.dto.OdsDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_ods")
public class Ods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "ods", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Goal> goals = new ArrayList<>();

    public Ods(OdsDTO dto) {
        this.id = dto.getId();
        this.title = dto.getTitle();
        this.description = dto.getDescription();
        this.createdAt = dto.getCreatedAt();
        this.goals = dto.getGoals()
                .stream()
                .map(Goal::new)
                .collect(Collectors.toList());
    }

}
