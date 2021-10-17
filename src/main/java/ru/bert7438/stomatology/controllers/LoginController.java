package ru.bert7438.stomatology.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bert7438.stomatology.entities.Admin;
import ru.bert7438.stomatology.entities.Appointment;
import ru.bert7438.stomatology.repositories.AppointmentRepository;

import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    AppointmentRepository appointmentRepository;
    private final Admin GOD = new Admin("admin", "admin");

    @GetMapping
    public String login(Model model){
        model.addAttribute("AdminForm", new Admin());
        return "login";
    }

    @PostMapping
    public String loginSuccess(@ModelAttribute("AdminForm") Admin admForm, BindingResult bindingResult, Model model){
        if(admForm.getLogin().equals(GOD.getLogin()) && admForm.getPassword().equals(GOD.getPassword())){
            List<Appointment> apps = appointmentRepository.findAll();
            model.addAttribute("appointments", apps);
            return "admin";
        }
        else{
            return "redirect:/";
        }
    }

}
