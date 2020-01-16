package com.example.webservice.web;

import com.example.webservice.dto.materials.MaterialsSaveRequestDto;
import com.example.webservice.service.MaterialsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private MaterialsService materialsService;


    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/materials")
    public Long savePosts(@RequestBody MaterialsSaveRequestDto dto){
        return materialsService.save(dto);
    }
}