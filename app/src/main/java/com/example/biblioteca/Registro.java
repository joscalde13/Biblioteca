package com.example.biblioteca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
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
    private static final int STORAGE_PERMISSION_CODE = 101;
    boolean permiso = false;




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

                    checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);
                    if(permiso = true){
                        try{
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
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }

                        } else{
                            Toast.makeText(Registro.this, "Error al crear el usuario", Toast.LENGTH_SHORT).show();
                        }
                    }

        });


    }

    /**
     * Metodo que verifica si se cuenta con permiso para acceder al almacenamiento
     * @param permission
     * @param requestCode
     */
    public void checkPermission(String permission, int requestCode){
        if (ContextCompat.checkSelfPermission(Registro.this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(Registro.this, new String[] { permission }, requestCode);
        } else {
            permiso = true;
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                permiso = true;
            } else {
                permiso = false;
            }
        }
    }
}