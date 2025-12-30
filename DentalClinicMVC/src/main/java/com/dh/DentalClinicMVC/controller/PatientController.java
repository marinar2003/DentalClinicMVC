package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.model.Dentist;
import com.dh.DentalClinicMVC.model.Patient;
import com.dh.DentalClinicMVC.service.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Para desarrollar APIs
@RequestMapping("/pacientes") //Ruta para entrar al controlador

public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    //Un endpoint que nos permita agregar pacientes
    @PostMapping //Agregar
    //El paciente viene en el cuerpo de la peticion con RequestBody
    public Patient save (@RequestBody Patient patient){
        return  patientService.save(patient);
    }

}
