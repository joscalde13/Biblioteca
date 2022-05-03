package com.example.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {



    public static Connection conexion;

    /**
     * Constructor de la clase
     */
    public Conexion(){

    }

    /**
     * Metodo que realiza la conexion a la base de datos
     * @return
     */
    public static Connection conectar(){
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.31.23:3306/moviles", "root", "Admon");
        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        return conn;
    }






}
