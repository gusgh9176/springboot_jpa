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
    public void Dto데이터가_posts테이블에_저장된다 () {
        //given
        MaterialsSaveRequestDto dto = MaterialsSaveRequestDto.builder()
                .price("10,000원")
                .standard("jojoldu@gmail.com")
                .item("테스트")
                .classification("테스트 타이틀")
                .build();

        //when
        materialsService.save(dto);

        //then
        Materials posts = materialsRepository.findAll().get(0);
        assertThat(posts.getPrice()).isEqualTo(dto.getPrice());
        assertThat(posts.getStandard()).isEqualTo(dto.getStandard());
        assertThat(posts.getItem()).isEqualTo(dto.getItem());
        assertThat(posts.getClassification()).isEqualTo(dto.getClassification());
    }
}