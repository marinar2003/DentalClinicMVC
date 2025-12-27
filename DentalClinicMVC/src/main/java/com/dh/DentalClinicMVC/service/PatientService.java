package com.dh.DentalClinicMVC.service;

import com.dh.DentalClinicMVC.dao.IDao;
import com.dh.DentalClinicMVC.dao.PatientDao;
import com.dh.DentalClinicMVC.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private IDao<Patient> patientIDao;

    //CONSTRUCTOR
    public PatientService(){
        this.patientIDao = new PatientDao();
    }

    //  METODOS
    public Patient save (Patient patient){
        return patientIDao.save(patient);
    }

    public Patient findByAll(Integer id){
        return  patientIDao.findById(id);
    }

    public void update (Patient patient){
        patientIDao.update(patient);
    }

    public void delete (Integer id){
        patientIDao.delete(id);
    }

    public List<Patient> findAll(){
        return patientIDao.findAll();
    }

    public Patient findByEmail(String email){
        return patientIDao.findByString(email);
    }

}
