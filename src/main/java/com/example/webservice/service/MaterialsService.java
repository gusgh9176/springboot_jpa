package com.example.webservice.service;

import com.example.webservice.domain.materials.MaterialsRepository;
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

    @Transactional(readOnly = true)
    public List<MaterialsMainResponseDto> findAllDesc() {
        return materialsRepository.findAllDesc()
                .map(MaterialsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MaterialsMainResponseDto> findSkeleton() {
        return materialsRepository.findSkeleton()
                .map(MaterialsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MaterialsMainResponseDto> findInsulation() {
        return materialsRepository.findInsulation()
                .map(MaterialsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MaterialsMainResponseDto> findExterior() {
        return materialsRepository.findExterior()
                .map(MaterialsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MaterialsMainResponseDto> findInterior() {
        return materialsRepository.findInterior()
                .map(MaterialsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MaterialsMainResponseDto> findWindow() {
        return materialsRepository.findWindow()
                .map(MaterialsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}