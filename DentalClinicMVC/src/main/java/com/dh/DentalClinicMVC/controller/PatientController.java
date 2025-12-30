package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.model.Dentist;
import com.dh.DentalClinicMVC.model.Patient;
import com.dh.DentalClinicMVC.service.PatientService;
import org.springframework.web.bind.annotation.*;

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

    //Un endponit que nos permita actualizar un paciente ya agregado
    @PutMapping
    public void update (Patient patient){
        patientService.update(patient);
    }

}
