package com.example.webservice.web;

import com.example.webservice.service.MaterialsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private MaterialsService materialsService;

    @GetMapping("test")
    public String test(){
        return "test";
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("skeletons", materialsService.findSkeleton());
        model.addAttribute("insulations", materialsService.findInsulation());
        model.addAttribute("exteriors", materialsService.findExterior());
        model.addAttribute("interiors", materialsService.findInterior());
        model.addAttribute("windows", materialsService.findWindow());

        return "main";
    }

}