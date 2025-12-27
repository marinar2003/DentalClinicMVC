package com.dh.DentalClinicMVC.dao;

import com.dh.DentalClinicMVC.model.Dentist;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DentistDao implements IDao<Dentist>{

    private static final String SQL_INSERT = "INSERT INTO DENTIST" +
            "(REGISTRATION, NAME, LAST_NAME) VALUES (?,?,?)";

    @Override
    public Dentist save(Dentist dentist) {
        Connection connection = null;
        try{
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,dentist.getRegistration());
            ps.setString(2, dentist.getName());
            ps.setString(3, dentist.getLastName());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                dentist.setId(rs.getInt(1));
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
          try{
              connection.close();
          }catch (Exception e){
              e.printStackTrace();
          }
        }
        return dentist;
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

    @Override
    public Dentist findByString(String value) {
        return null;
    }
}
