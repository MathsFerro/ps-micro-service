package com.matheus.ps.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.matheus.ps.entities.Ods;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OdsDTO implements Serializable {

    private Long id;
    private String title;
    private String description;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonManagedReference
    private List<GoalDTO> goals = new ArrayList<>();

    public OdsDTO(Ods entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.createdAt = entity.getCreatedAt();
        this.goals = entity.getGoals()
                .stream()
                .map(GoalDTO::new)
                .collect(Collectors.toList());
    }

}
