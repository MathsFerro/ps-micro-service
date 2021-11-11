package com.matheus.ps.services.impl;

import com.matheus.ps.dto.GoalDTO;
import com.matheus.ps.dto.OdsDTO;
import com.matheus.ps.entities.Ods;
import com.matheus.ps.repositories.OdsRepository;
import com.matheus.ps.services.GoalService;
import com.matheus.ps.services.OdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OdsServiceImpl implements OdsService {

    @Autowired
    private OdsRepository odsRepository;

    @Autowired
    private GoalService goalService;

    @Override
    public OdsDTO add(OdsDTO dto) {
        Ods ods = new Ods(dto);
        return new OdsDTO(odsRepository.save(ods));
    }

    @Override
    public OdsDTO findById(Long id) {
        return odsRepository.findById(id).map(OdsDTO::new).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public OdsDTO update(Long id, OdsDTO dtoUpdated) {
        return odsRepository.findById(id).map(ods -> {
            dtoUpdated.setId(ods.getId());
            dtoUpdated.setCreatedAt(ods.getCreatedAt());
            return new OdsDTO(odsRepository.save(new Ods(dtoUpdated)));
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<OdsDTO> findAll() {
        return odsRepository.findAll().stream().map(OdsDTO::new).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        OdsDTO dto = findById(id);
        for(GoalDTO goalDTO : dto.getGoals()) {
            goalService.deleteById(goalDTO.getId());
        }

        odsRepository.deleteById(id);
    }
}
