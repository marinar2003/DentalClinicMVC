package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.model.Dentist;
import com.dh.DentalClinicMVC.service.DentistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Para desarrollar APIs
@RequestMapping("/odontologos")
public class DentistController {

    private DentistService dentistService;

    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    //CONSULTAR ODONTOLOGOS POR ID
    @GetMapping("/{id}")
    public Dentist findById(@PathVariable Integer id){
        return dentistService.findById(id);
    }

    //GUARDAR UN NUEVO ODONTOLOGO EN LA BD
    @PostMapping
    public Dentist save(@RequestBody Dentist dentist){
        return dentistService.save(dentist);
    }

    //ACTUALIZAR UN ODONTOLOGO
    @PutMapping
    public void update (@RequestBody Dentist dentist){
        dentistService.update(dentist);
    }

    //BORRAR UN ODONTOLOGO
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        dentistService.delete(id);
    }

    //LISTA DE ODONTOLOGOS
     @GetMapping
    public List<Dentist> findAll(){
        return dentistService.findAll();
     }
}
