package com.matheus.ps.services.impl;

import com.matheus.ps.dto.GoalDTO;
import com.matheus.ps.entities.Goal;
import com.matheus.ps.repositories.GoalRepository;
import com.matheus.ps.services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalServiceImpl implements GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Override
    public GoalDTO add(GoalDTO dto) {
        Goal goal = new Goal(dto);
        return new GoalDTO(goalRepository.save(goal));
    }

    @Override
    public GoalDTO findById(Long id) {
        return goalRepository.findById(id).map(GoalDTO::new).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GoalDTO update(Long id, GoalDTO dtoUpdated) {
        return goalRepository.findById(id).map(goal -> {
            dtoUpdated.setId(goal.getId());
            dtoUpdated.setCreatedAt(goal.getCreatedAt());
            return new GoalDTO(goalRepository.save(new Goal(dtoUpdated)));
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<GoalDTO> findAll() {
        return goalRepository.findAll().stream().map(GoalDTO::new).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        goalRepository.deleteById(id);
    }
}
