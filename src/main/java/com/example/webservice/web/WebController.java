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

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", materialsService.findAllDesc());
        return "main";
    }

}