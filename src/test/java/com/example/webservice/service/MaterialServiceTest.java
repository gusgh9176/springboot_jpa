package com.example.webservice.service;

import com.example.webservice.domain.materials.Materials;
import com.example.webservice.domain.materials.MaterialsRepository;
import com.example.webservice.dto.materials.MaterialsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialServiceTest {

    @Autowired
    private MaterialsService materialsService;

    @Autowired
    private MaterialsRepository materialsRepository;

    @After
    public void cleanup () {
        materialsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_materials테이블에_저장된다 () {
        //given
        MaterialsSaveRequestDto dto = MaterialsSaveRequestDto.builder()
                .price(10000)
                .standard("2.7m")
                .item("테스트")
                .classification("테스트 품목")
                .build();

        //when
        materialsService.save(dto);

        //then
        Materials materials = materialsRepository.findAll().get(0);
        assertThat(materials.getPrice()).isEqualTo(dto.getPrice());
        assertThat(materials.getStandard()).isEqualTo(dto.getStandard());
        assertThat(materials.getItem()).isEqualTo(dto.getItem());
        assertThat(materials.getClassification()).isEqualTo(dto.getClassification());
    }
}