package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText txtNickname;
    EditText txtPassword;
    EditText txtNombre;
    EditText txtApellido;
    EditText txtDPI;
    EditText txtCorreo;
    Button btnguardarRegistro;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        this.txtNickname = findViewById(R.id.txtNickname);
        this.txtPassword = findViewById(R.id.txtPassword);
        this.txtNombre = findViewById(R.id.txtNombre);
        this.txtApellido = findViewById(R.id.txtApellido);
        this.txtDPI = findViewById(R.id.txtDPI);
        this.txtCorreo = findViewById(R.id.txtCorreo);
        this.btnguardarRegistro = findViewById(R.id.btnguardarRegistro);




                    checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);
                    if(permiso = true){
                        try{
                            Usuario userRequest = new Usuario();
                            userRequest.setNickname(txtNickname.getText().toString());
                            userRequest.setPassword(txtPassword.getText().toString());
                            userRequest.setNombre(txtNombre.getText().toString());
                            userRequest.setApellido(txtApellido.getText().toString());
                            userRequest.setDpi(txtDPI.getText().toString());
                            userRequest.setCorreo(txtCorreo.getText().toString());
                            userRequest.setIdEstado(1);
                            String resultado = new RegistroUsuario().execute(userRequest).get();
                            if(resultado.equals("exito")){
                                Toast.makeText(Registro.this, "SE HA REGISTRADO CON EXITO", Toast.LENGTH_LONG).show();
                                Intent navegacion = new Intent(Registro.this, Login.class);
                                startActivity(navegacion);
                            }else{
                                Toast.makeText(Registro.this, "Error al crear el usuario", Toast.LENGTH_LONG).show();
                            }
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }
                        }else{
                            Toast.makeText(Registro.this, "Error al crear el usuario", Toast.LENGTH_SHORT).show();
                        }
                    }



    }













