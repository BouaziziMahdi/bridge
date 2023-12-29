package com.bridge.bridge.controller;

import com.bridge.bridge.dto.CoursDto;
import com.bridge.bridge.models.Cours;
import com.bridge.bridge.services.CoursServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/cours")
@RequiredArgsConstructor
@Tag(name = "Users")
public class CoursController {
    private final CoursServices coursServices ;
    @PostMapping("/create")
    public ResponseEntity<Integer> createCours(@RequestBody CoursDto coursDto) {
        Integer courseId = coursServices.saveCours(coursDto);
        return new ResponseEntity<> (courseId, HttpStatus.CREATED);
    }
@GetMapping("/find")
        public List<CoursDto> findAll() {
        return coursServices.findAll();
    }
    @PutMapping("/update/{id}")
    public void updateCours(@PathVariable Integer id, @RequestBody CoursDto coursDto) {
        coursServices.updateCours(id, coursDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        coursServices.deleteById(id);
    }
}
