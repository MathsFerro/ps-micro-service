package com.matheus.ps.controllers;

import com.matheus.ps.dto.OdsDTO;
import com.matheus.ps.services.OdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ods")
public class OdsController {

    @Autowired
    private OdsService odsService;

    @PostMapping
    public ResponseEntity<OdsDTO> add(@RequestBody OdsDTO dto) {
        return new ResponseEntity<>(odsService.add(dto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<OdsDTO> update(@PathVariable("id") Long id, @RequestBody OdsDTO dto) {
        return new ResponseEntity<>(odsService.update(id, dto), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<OdsDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(odsService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OdsDTO>> findAll() {
        return new ResponseEntity<>(odsService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long id) {
        odsService.deleteById(id);
    }
}
