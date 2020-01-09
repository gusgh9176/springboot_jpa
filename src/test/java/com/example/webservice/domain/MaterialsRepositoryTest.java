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
    MaterialsRepository postsRepository;

    @After
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        postsRepository.save(Materials.builder()
                .classification("test title")
                .item("test content")
                .standard("jojoldu@gmail.com")
                .price("10,000원")
                .build());

        //when
        List<Materials> postsList = postsRepository.findAll();

        //then
        Materials posts = postsList.get(0);
        assertThat(posts.getClassification(), is("test title"));
        assertThat(posts.getItem(), is("test content"));
    }

    @Test
    public void BaseTimeEntity_등록 () {
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Materials.builder()
                .classification("테스트 게시글")
                .item("테스트 본문")
                .standard("jojoldu@gmail.com")
                .price("10,000원")
                .build());
        //when
        List<Materials> postsList = postsRepository.findAll();

        //then
        Materials posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}