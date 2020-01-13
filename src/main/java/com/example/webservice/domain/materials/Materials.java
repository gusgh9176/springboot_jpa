package com.example.webservice.domain.materials;

import com.example.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Materials extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String classification;

    @Column(nullable = false)
    private String item;

    @Column(nullable = false)
    private String standard;

    @Column(nullable = false)
    private String price;

    @Builder
    public Materials(String classification, String item, String standard, String price) {
        this.classification = classification;
        this.item = item;
        this.standard = standard;
        this.price = price;
    }
}