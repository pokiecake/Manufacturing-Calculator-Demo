package org.pokiecake.blueprintcalculator.controller;

import org.pokiecake.blueprintcalculator.entity.Part;
import org.pokiecake.blueprintcalculator.service.PartsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    PartsService partsService;

    public MainController(PartsService partsService) {
        this.partsService = partsService;
    }

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/parts")
    public String getParts(Model theModel) {
        List<Part> parts = partsService.getAllParts();

        theModel.addAttribute("parts", parts);

        return "parts";
    }
}
