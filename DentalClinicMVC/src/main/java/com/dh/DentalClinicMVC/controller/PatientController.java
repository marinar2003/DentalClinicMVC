package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.model.Patient;
import com.dh.DentalClinicMVC.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller//Utilizamos tecnologia de vista por eso controller, si fuese una Api seria RestController
@RequestMapping("/patient") // Para mapear, darle una ruta a las request  que entren
public class PatientController {

    private PatientService patientService;

    //CONSTRUCTOR
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    // Con MODEL me llevo informacion a la vista
    @GetMapping
    public String findPatientByEmail(Model model, @RequestParam("email") String email){
         Patient patient = patientService.findByEmail(email);
         model.addAttribute("name",patient.getName());
         model.addAttribute("lastName", patient.getLastName());
         return "index";
    }
}
