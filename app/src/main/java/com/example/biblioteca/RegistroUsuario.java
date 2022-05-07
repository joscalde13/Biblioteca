package com.example.biblioteca;

import android.os.AsyncTask;

import java.sql.Statement;
import java.util.List;

public class RegistroUsuario extends AsyncTask<Usuario, Void, String> {


    /**
     * Metodo que realiza el registro de un nuevo usuario
     * @param datos
     * @return
     */
    @Override
    protected String doInBackground(Usuario... datos) {
        String respuesta;
        try{
            Conexion.conexion = Conexion.conectar();
            String sql = "insert into moviles.usuario(nickname, password, nombre, apellido, dpi, correo, foto) values('"+datos[0].getNickname()+"','"+datos[0].getPassword()+"','"+datos[0].getNombre()+"','"+datos[0].getApellido()+"','"+datos[0].getDpi()+"','"+datos[0].getCorreo()+"',' '"+datos[0].getFoto()+"')";
            Statement st = Conexion.conexion.createStatement();

            int rs = st.executeUpdate(sql);
            if(rs == 1){
                respuesta = "exito";
            } else{
                respuesta = "error";
            }
        } catch(Exception ex){
            ex.printStackTrace();
            respuesta = "error";
        }
        return respuesta;
    }


}
