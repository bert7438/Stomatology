package ru.bert7438.stomatology.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorsController {
    @GetMapping("/doctors")
    public String doctors(){
        return "doctors";
    }
}
