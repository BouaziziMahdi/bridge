package com.bridge.bridge.services;

import com.bridge.bridge.dto.CoursDto;
import com.bridge.bridge.repositories.CoursRepository;
import com.bridge.bridge.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoursServices {
    private final CoursRepository coursRepository;
    private final ObjectsValidator objectsValidator;
    public Integer createCours(CoursDto coursDto) {
        objectsValidator.validate(coursDto);
        var cour = CoursDto.fromDtoToEntity (coursDto);
             return coursRepository.save(cour).getId();
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
