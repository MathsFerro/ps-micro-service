package com.matheus.ps.services;

import com.matheus.ps.dto.OdsDTO;

import java.util.List;

public interface OdsService {
    OdsDTO add(OdsDTO dto);
    OdsDTO findById(Long id);
    OdsDTO update(Long id, OdsDTO dtoUpdated);
    List<OdsDTO> findAll();
    void deleteById(Long id);
}
