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
    private MaterialsRepository postsRepository;

    @Transactional
    public Long save(MaterialsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<MaterialsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(MaterialsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}