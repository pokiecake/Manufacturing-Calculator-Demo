package org.pokiecake.blueprintcalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/managers")
    public String getManagerHome() {
        return "manager-home";
    }
}
