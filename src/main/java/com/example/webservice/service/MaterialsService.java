package com.example.webservice.service;


import com.example.webservice.domain.materials.MaterialsRepository;
import com.example.webservice.dto.materials.MaterialsDeleteRequestDto;
import com.example.webservice.dto.materials.MaterialsMainResponseDto;
import com.example.webservice.dto.materials.MaterialsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MaterialsService {
    private MaterialsRepository materialsRepository;

    @Transactional
    public Long save(MaterialsSaveRequestDto dto){
        return materialsRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long delete(MaterialsDeleteRequestDto dto){
        materialsRepository.deleteById(dto.getId());
        return dto.getId();
    }

    @Transactional(readOnly = true)
    public List<MaterialsMainResponseDto> findAllDesc() {
        return materialsRepository.findAllDesc()
                .map(MaterialsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MaterialsMainResponseDto> findSkeleton() {
        return materialsRepository.findByClassification("골조")
                .map(MaterialsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MaterialsMainResponseDto> findInsulation() {
        return materialsRepository.findByClassification("단열")
                .map(MaterialsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MaterialsMainResponseDto> findExterior() {
        return materialsRepository.findByClassification("외장마감")
                .map(MaterialsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MaterialsMainResponseDto> findInterior() {
        return materialsRepository.findByClassification("내장마감")
                .map(MaterialsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MaterialsMainResponseDto> findWindow() {
        return materialsRepository.findByClassification("창호")
                .map(MaterialsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}