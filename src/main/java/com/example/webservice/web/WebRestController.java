package com.example.webservice.web;

import com.example.webservice.dto.materials.MaterialsDeleteRequestDto;
import com.example.webservice.dto.materials.MaterialsSaveRequestDto;
import com.example.webservice.service.MaterialsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WebRestController {

    private MaterialsService materialsService;

    @PostMapping("materials/insert")
    public Long saveMaterials(@RequestBody MaterialsSaveRequestDto dto){
        return materialsService.save(dto);
    }

    @PostMapping("materials/delete")
    public Long deleteMaterials(@RequestBody MaterialsDeleteRequestDto dto) { return materialsService.delete(dto);}

}