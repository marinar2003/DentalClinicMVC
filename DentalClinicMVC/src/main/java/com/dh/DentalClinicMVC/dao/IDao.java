package com.dh.DentalClinicMVC.dao;

import java.util.List;

public interface IDao <T>{

    //FIRMA DE LOS METODOS
    T save(T t);

    T findById(Integer id);

    void update(T t);

    void delete (Integer id);

    List<T> findAll();

    T findByString (String value);
}
