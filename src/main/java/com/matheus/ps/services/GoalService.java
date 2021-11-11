package com.matheus.ps.services;

import com.matheus.ps.dto.GoalDTO;

import java.util.List;

public interface GoalService {
    GoalDTO add(GoalDTO dto);
    GoalDTO findById(Long id);
    GoalDTO update(Long id, GoalDTO dtoUpdated);
    List<GoalDTO> findAll();
    void deleteById(Long id);
}
