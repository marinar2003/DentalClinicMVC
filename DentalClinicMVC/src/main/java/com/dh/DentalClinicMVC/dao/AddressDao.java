package com.dh.DentalClinicMVC.dao;

import com.dh.DentalClinicMVC.model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class AddressDao implements IDao<Address> {

    public static final String SQL_INSERT = "INSERT TO ADDRESSES (STREET, NUMBER, LOCATION, PROVINCE) VALUES (?,?,?,?)";

    //GUARDAR UN DOMICILIO
    @Override
    public Address save(Address address) {

        Connection connection = null;

        try {
            connection = DB.getConnectioin();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, address.getStreet());
            ps.setInt(2,address.getNumber());
            ps.setString(3, address.getLocation());
            ps.setString(4, address.getProvince());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                address.setId(rs.getInt(1));
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
        return null;
    }

    @Override
    public Address findById(Integer id) {
        return null;
    }

    @Override
    public void update(Address address) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Address> findAll() {
        return List.of();
    }
}
