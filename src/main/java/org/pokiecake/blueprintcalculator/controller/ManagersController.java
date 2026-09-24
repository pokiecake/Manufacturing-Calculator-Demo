package org.pokiecake.blueprintcalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/managers")
public class ManagersController {

    @GetMapping("/")
    public String getManagerHome() {
        return "manager-home";
    }
}
