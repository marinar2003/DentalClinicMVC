package com.dh.DentalClinicMVC.service;

import com.dh.DentalClinicMVC.dao.DentistDao;
import com.dh.DentalClinicMVC.dao.IDao;
import com.dh.DentalClinicMVC.model.Dentist;
import com.dh.DentalClinicMVC.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistService {

    private IDao<Dentist> dentistIDao;

    //CONSTRUCTOR

    public DentistService(){
        this.dentistIDao = new DentistDao();
    }

    //  METODOS
    public Dentist save (Dentist dentist){
        return dentistIDao.save(dentist);
    }

    public Dentist findById(Integer id){
        return  dentistIDao.findById(id);
    }

    public void update (Dentist dentist){
        dentistIDao.update(dentist);
    }

    public void delete (Integer id){
        dentistIDao.delete(id);
    }

    public List<Dentist> findAll(){
        return dentistIDao.findAll();
    }

    public Dentist findByEmail(String email){
        return dentistIDao.findByString(email);
    }
}
