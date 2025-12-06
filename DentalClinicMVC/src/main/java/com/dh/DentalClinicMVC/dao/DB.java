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

    //CREACION DE LAS CONSTANTES PARA LAS TABLAS

    private static final String SQL_DROP_CREATE_ADDRESSES = "DROP TABLE IF EXISTS " +
            "ADDRESSES; CREATE TABLE ADDRESSES (ID INT AUTO_INCREMENT PRIMARY KEY," +
            " STREET VARCHAR(100) NOT NULL," +
            " NUMBER INT  NOT NULL," +
            " LOCATION VARCHAR(100) NOT NULL," +
            " PROVINCE VARCHAR(100) NOT NULL)";

    private static final String SQL_DROP_CREATE_PATIENT = "DROP TABLE IF EXISTS " +
            "PATIENT; CREATE TABLE PATIENT (ID INT AUTO_INCREMENT PRIMARY KEY," +
            " NAME VARCHAR(100) NOT NULL," +
            " LAST_NAME VARCHAR(100) NOT NULL," +
            " EMAIL VARCHAR(100) NOT NULL," +
            " CARD_IDENTITY INT NOT NULL," +
            " ADMISSION_OF_DATE DATE NOT NULL," +
            " ADDRESS_ID INT NOT NULL)";


    private static final String SQL_DROP_CREATE_DENTIST = "DROP TABLE IF EXISTS " +
            "DENTIST; CREATE TABLE DENTIST (ID INT AUTO_INCREMENT PRIMARY KEY," +
            " REGISTRATION INT NOT NULL," +
            " NAME VARCHAR(100) NOT NULL," +
            " LAST_NAME VARCHAR(100) NOT NULL)";

    //INSERTAR VALORES PREDETERMINADOS EN LAS TABLAS
        private static final String SQL_INSERT = "INSERT TO ADDRESSES (STREET, NUMBER, LOCATION, PROVINCE) VALUES" +
            " ('Calle A', 101, 'Laboulaye', 'Córdoba');" +
            " INSERT TO PATIENT (NAME, LAST_NAME, EMAILM  CARD_IDENTITY, ADMISSION_OF_DATE, ADDRESS_ID) VALUES" +
            " ('Marina', 'Revol', 'mnrevol50@gmial.com', 35258777, '2025-11-30',1);" +
            " INSERT TO DENTIST (REGISTRATION, NAME, LAST_NAME) VALUES" +
            " (1234, 'Juan', 'Muela')";


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
            //EJECUTAR LAS ORDENES SQL
            statement.execute(SQL_DROP_CREATE_ADDRESSES);
            statement.execute(SQL_DROP_CREATE_PATIENT);
            statement.execute(SQL_DROP_CREATE_DENTIST);
            statement.execute(SQL_INSERT);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                connection.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
