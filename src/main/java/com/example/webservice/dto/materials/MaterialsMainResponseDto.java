package com.example.webservice.dto.materials;

import com.example.webservice.domain.materials.Materials;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class MaterialsMainResponseDto {
    private Long id;
    private String classification;
    private String item;
    private String standard;
    private String price;
    private String modifiedDate;

    public MaterialsMainResponseDto(Materials entity) {
        id = entity.getId();
        classification = entity.getClassification();
        item = entity.getItem();
        standard = entity.getStandard();
        price = entity.getPrice();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

    /**
     * Java 7 버전
     */
    private String toStringDateTimeByJava7(LocalDateTime localDateTime){
        if(localDateTime == null){
            return "";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(localDateTime);
    }
}
