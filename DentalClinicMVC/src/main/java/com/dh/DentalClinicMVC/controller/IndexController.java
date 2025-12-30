package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.model.Dentist;
import com.dh.DentalClinicMVC.model.Patient;
import com.dh.DentalClinicMVC.service.DentistService;
import com.dh.DentalClinicMVC.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller//Utilizamos tecnologia de vista por eso controller, si fuese una Api seria RestController
@RequestMapping("/index") // Para mapear, darle una ruta a las request  que entren
public class IndexController {

    private PatientService patientService;

    private DentistService dentistService;

    //CONSTRUCTOR
    public IndexController(PatientService patientService, DentistService dentistService) {
        this.patientService = patientService;
        this.dentistService = dentistService;
    }
    // Con MODEL me llevo informacion a la vista
    @GetMapping
    public String findPatientByEmail(Model model, @RequestParam("email") String email, @RequestParam("id") Integer id){
        Patient patient = patientService.findByEmail(email);
        //buscamos al odontologo por id
        Dentist dentist = dentistService.findById(id);

        //Enlazar el back cn la vista
        model.addAttribute("name",patient.getName());
        model.addAttribute("lastName", patient.getLastName());
        //agregar la vista que corresponde con odontologo
        model.addAttribute("nameDentist", dentist.getName());
        model.addAttribute("lastNameDentist", dentist.getLastName());
        model.addAttribute("registration", dentist.getRegistration());
         return "index";
    }
}
