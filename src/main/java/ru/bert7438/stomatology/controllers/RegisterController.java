package ru.bert7438.stomatology.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bert7438.stomatology.entities.Appointment;
import ru.bert7438.stomatology.repositories.AppointmentRepository;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public RegisterController(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping
    public String register(Model model){
        model.addAttribute("UserForm", new Appointment());
        return "register";
    }
    @PostMapping
    public String addAppointment(@ModelAttribute("UserForm") Appointment appForm, BindingResult bindingResult){
        appointmentRepository.saveAndFlush(appForm);
        return "redirect:/";
    }
}
