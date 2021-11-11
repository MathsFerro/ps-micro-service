package com.matheus.ps.controllers;

import com.matheus.ps.dto.GoalDTO;
import com.matheus.ps.services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/goal")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @PostMapping
    public ResponseEntity<GoalDTO> add(@RequestBody GoalDTO dto) {
        return new ResponseEntity<>(goalService.add(dto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<GoalDTO> update(@PathVariable("id") Long id, @RequestBody GoalDTO dto) {
        return new ResponseEntity<>(goalService.update(id, dto), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<GoalDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(goalService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GoalDTO>> findAll() {
        return new ResponseEntity<>(goalService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteById(Long id) {
        goalService.deleteById(id);
    }
}
