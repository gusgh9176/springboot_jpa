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

    private String title;
    private String content;
    private String author;

    @Builder
    public MaterialsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Materials toEntity(){
        return Materials.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}