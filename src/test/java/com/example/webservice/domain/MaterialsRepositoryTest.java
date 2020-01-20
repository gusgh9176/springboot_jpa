package com.example.webservice.domain;

import com.example.webservice.domain.materials.Materials;
import com.example.webservice.domain.materials.MaterialsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialsRepositoryTest {

    @Autowired
    MaterialsRepository materialsRepository;

    @After
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        materialsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        materialsRepository.save(Materials.builder()
                .classification("test classification")
                .item("test item")
                .standard("2.5m")
                .price(10000)
                .build());

        //when
        List<Materials> materialsList = materialsRepository.findAll();

        //then
        Materials posts = materialsList.get(0);
        assertThat(posts.getClassification(), is("test classification"));
        assertThat(posts.getItem(), is("test iteam"));
    }

    @Test
    public void BaseTimeEntity_등록 () {
        //given
        LocalDateTime now = LocalDateTime.now();
        materialsRepository.save(Materials.builder()
                .classification("테스트 골조")
                .item("테스트 아이템")
                .standard("2.6m")
                .price(10000)
                .build());
        //when
        List<Materials> materialsList = materialsRepository.findAll();

        //then
        Materials posts = materialsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}