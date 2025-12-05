package com.dh.DentalClinicMVC.dao;

import com.dh.DentalClinicMVC.model.Address;
import com.dh.DentalClinicMVC.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDao implements IDao<Patient> {
    //CREAR UN PACIENTE
    private static final String SQL_INSERT = "INSERT TO PATIENT (NAME, LAST_NAME, CARD_IDENTITY, ADMISSION_OF_DATE, ADDRESS_ID)" +
    " VALUES (?,?,?,?,?)";
    //BUSCAR POR ID
    private static final String SQL_SELECT_ID = "SELECT * FROM PATIENT WHERE ID=?";
    //ACTUALIZAR
    private static final String SQL_UPDATE = "UPDATE PATIENT SET NAME=?, LAST_NAME=?, CARD_IDENTITY=?, ADMISSION_OF_DATE=?, ADDRESS_ID=? WHERE ID=?";
    //BORRAR
    private static final String SQL_DELETE = "DELETE FROM PATIENT WHERE ID=?";
    //LISTAR TODOS
    private static final String SQL_SELECT_ALL = "SELECT * FROM PATIENT";

    //GUARDAR UN PACIENTE
    @Override
    public Patient save(Patient patient) {

        Connection connection = null;

        try{
            AddressDao addressDao = new AddressDao();
            addressDao.save(patient.getAddress());

            connection = DB.getConnectioin();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, patient.getLastName());
            ps.setString(2, patient.getLastName());
            ps.setInt(3,patient.getCardIdentity());
            ps.setDate(4, Date.valueOf(patient.getAdmissionOfDate()));
            ps.setInt(5,patient.getAddress().getId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            while (rs.next()){
                patient .setId(rs.getInt(1));
            }


        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                connection.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return patient;
    }

    @Override
    public Patient findById(Integer id) {
        Connection connection = null;
        Patient patient = null;

        try{
            connection = DB.getConnectioin();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, id); //setear el id
            ResultSet rs = ps.executeQuery();

             //recuperar el Id de adress para instanciarlo al pte
            AddressDao addressDao = new AddressDao();
            while (rs.next()){
                Address address = addressDao.findById(rs.getInt(6));
                patient = new Patient(rs.getInt(1),rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getDate(5).toLocalDate(), address);
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return patient;
    }

    @Override
    public void update(Patient patient) {
        Connection connection = null;

        try{
            connection = DB.getConnectioin();
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
            ps.setString(1,patient.getName());
            ps.setString(2,patient.getLastName());
            ps.setInt(3,patient.getCardIdentity());
            ps.setDate(4,Date.valueOf(patient.getAdmissionOfDate()));
            ps.setInt(5,patient.getAddress().getId());
            ps.setInt(6,patient.getId());
            ps.execute();

        }  catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                connection.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Integer id) {
        Connection connection = null;

        try{
            connection = DB.getConnectioin();
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            ps.execute();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<Patient> findAll() {
        Connection connection = null;
        Address address;
        List<Patient> patient = new ArrayList<>();

        try{
            AddressDao addressDao = new AddressDao();
            connection = DB.getConnectioin();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                address =addressDao.findById(rs.getInt(6));
                patient.add(new Patient(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getDate(5).toLocalDate(), address));
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                connection.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return patient;
    }
}
