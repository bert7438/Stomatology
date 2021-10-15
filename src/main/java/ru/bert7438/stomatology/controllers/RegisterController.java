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
import ru.bert7438.stomatology.entities.Doctor;
import ru.bert7438.stomatology.repositories.AppointmentRepository;
import ru.bert7438.stomatology.repositories.DoctorRepository;

import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public RegisterController(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository){
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
    }

    @GetMapping
    public String register(Model model){
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("doctors", doctors);
        model.addAttribute("UserForm", new Appointment());
        return "register";
    }

    @PostMapping
    public String addAppointment(@ModelAttribute("UserForm") Appointment appForm, BindingResult bindingResult){
        appointmentRepository.saveAndFlush(appForm);
        return "redirect:/";
    }
}
