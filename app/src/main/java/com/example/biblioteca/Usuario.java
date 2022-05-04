package com.example.biblioteca;

public class Usuario {


    private String nickname;
    private String password;
    private String nombre;
    private String apellido;
    private String dpi;
    private String correo;
    private String genero;
    private int idEstado;
    private String foto;




    /**
     * Constructor de la clase
     */
    public Usuario(){

    }

    //Metodos gets y sets
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    /*/public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }



}
