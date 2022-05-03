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
    EditText txtDpi;
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
        this.txtDpi = findViewById(R.id.txtDpi);
        this.txtCorreo = findViewById(R.id.txtCorreo);
        this.btnguardarRegistro = findViewById(R.id.btnguardarRegistro);



/**
 * Boton de registro de usuario
 */
        btnguardarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);
                    if(permiso = true){
                        Usuario userRequest = new Usuario();
                        userRequest.setNickname(txtNickname.getText().toString());
                        userRequest.setPassword(txtPassword.getText().toString());
                        userRequest.setNombre(txtNombre.getText().toString());
                        userRequest.setApellido(txtApellido.getText().toString());
                        userRequest.setDpi(txtDpi.getText().toString());
                        userRequest.setCorreo(txtCorreo.getText().toString());
                        userRequest.setIdEstado(1);
                        String resultado = new RegistroUsuario().execute(userRequest).get();
                        if(resultado.equals("exito")){
                            Intent navegacion = new Intent(Registro.this, Login.class);
                            startActivity(navegacion);
                            Toast.makeText(Registro.this, "SE HA REGISTRADO CON EXITO", Toast.LENGTH_LONG).show();
                            }
                            }
                        } else{
                            Toast.makeText(Registro.this, "Error al crear el usuario", Toast.LENGTH_SHORT).show();
                        }

                    }
                    }
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });













    }
}