package com.dh.DentalClinicMVC.dao;

import ch.qos.logback.core.encoder.EchoEncoder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {

    public static final String DRIVER = "org.h2.Driver";

    public static final String URL = "jdbc:h2:./dc";

    private static final String USER = "sa";

    private static final String PASSWORD ="sa";

    // CONEXION A BASE DE DATOS
    public static Connection getConnectioin() throws Exception{
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    //CREACION DE LAS TABLAS
    public  static void createTables(){
        Connection connection = null;

        try{
            connection = getConnectioin();
            Statement statement = connection.createStatement();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
