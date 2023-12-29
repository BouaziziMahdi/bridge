package com.bridge.bridge.services;

import com.bridge.bridge.dto.CoursDto;
import com.bridge.bridge.models.Cours;
import com.bridge.bridge.repositories.CoursRepository;
import com.bridge.bridge.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoursServices {
    private final CoursRepository coursRepository;
    private final ObjectsValidator objectsValidator;

    public Integer saveCours(CoursDto coursDto) {
        objectsValidator.validate(coursDto);
        Cours cours = CoursDto.fromDtoToEntity(coursDto);
        Cours savedCours = coursRepository.save(cours);
        return savedCours.getId();
    }
    public List<CoursDto> findAll() {
        return coursRepository.findAll()
                .stream()
                .map( CoursDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public CoursDto findById(Integer id) {
        return coursRepository.findById(id)
                .map(CoursDto::fromEntityToDto)
                .orElseThrow(() -> new EntityNotFoundException ("No cour found with the ID:: " + id));
    }
    public void deleteById(Integer id) {
        coursRepository.deleteById(id);
    }
    public void updateCours(Integer id, CoursDto coursDto) {
        coursRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException ("No cour found with the ID:: " + id));
        coursDto.setId(id);
        objectsValidator.validate(coursDto);
        coursRepository.save(CoursDto.fromDtoToEntity(coursDto));
    }
}
