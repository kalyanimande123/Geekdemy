package com.geekdemyapplication.controller;


import com.geekdemyapplication.entity.Programme;
import com.geekdemyapplication.repo.ProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programmes")
public class ProgrammeController {
    @Autowired
    private ProgrammeRepository programmeRepository;

    @GetMapping("/allprograms")
    public List<Programme> getProgrammes() {
        return programmeRepository.findAll();
    }

    @PostMapping("/saveprograms")
    public Programme createProgramme(@RequestBody Programme programme) {
        return programmeRepository.save(programme);
    }
}