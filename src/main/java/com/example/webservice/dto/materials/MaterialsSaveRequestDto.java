package com.example.webservice.dto.materials;

import com.example.webservice.domain.materials.Materials;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MaterialsSaveRequestDto {

    private String classification;
    private String item;
    private String standard;
    private Integer price;

    @Builder
    public MaterialsSaveRequestDto(String classification, String item, String standard, Integer price) {
        this.classification = classification;
        this.item = item;
        this.standard = standard;
        this.price = price;
    }

    public Materials toEntity(){
        return Materials.builder()
                .classification(classification)
                .item(item)
                .standard(standard)
                .price(price)
                .build();
    }
}