package com.example.webservice.dto.materials;

import com.example.webservice.domain.materials.Materials;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MaterialsDeleteRequestDto {
    private Long id;

    @Builder
    public MaterialsDeleteRequestDto(Materials entity) {
        id = entity.getId();
    }
}
