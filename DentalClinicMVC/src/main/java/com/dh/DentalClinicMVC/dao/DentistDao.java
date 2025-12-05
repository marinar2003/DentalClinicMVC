package com.dh.DentalClinicMVC.dao;

import com.dh.DentalClinicMVC.model.Dentist;
import com.sun.jdi.connect.spi.Connection;

import java.sql.PreparedStatement;
import java.util.List;

public class DentistDao implements IDao<Dentist>{

    @Override
    public Dentist save(Dentist dentist) {
        Connection connection = null;

        try{


        }catch(Exception e){
            e.printStackTrace();
        }finally {
          try{
              connection.close();
          }catch (Exception e){
              e.printStackTrace();
          }
        }
        return null;
    }

    @Override
    public Dentist findById(Integer id) {
        return null;
    }

    @Override
    public void update(Dentist dentist) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Dentist> findAll() {
        return List.of();
    }
}
