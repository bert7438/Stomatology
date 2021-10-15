package ru.bert7438.stomatology.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.bert7438.stomatology.entities.Doctor;
import ru.bert7438.stomatology.repositories.DoctorRepository;

import java.util.List;

@Controller
public class DoctorsController {
    @Autowired
    DoctorRepository doctorRepository;
    @GetMapping("/doctors")
    public String doctors(Model model){
        List<Doctor> doctorList = doctorRepository.findAll();
        model.addAttribute("doctorList", doctorList);
        return "doctors";
    }
}
