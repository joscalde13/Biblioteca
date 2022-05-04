package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText txtusuario;
    private EditText txtpassword;
    private Button btningresar;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        this.txtusuario = findViewById(R.id.txtusuario);
        this.txtpassword = findViewById(R.id.txtpasswordd);
        this.boton = findViewById(R.id.btnregistrarse);
        this.btningresar = findViewById(R.id.btningresar2);

        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Usuario userRequest = new Usuario();
                    userRequest.setNickname(txtusuario.getText().toString());
                    userRequest.setPassword(txtpassword.getText().toString());
                    Usuario userResponse = new Ingreso().execute(userRequest).get();
                    if(userResponse != null){
                        if(userResponse.getIdEstado() == 0){
                            Toast.makeText(getApplicationContext(), "Usuario Inactivo", Toast.LENGTH_SHORT).show();
                        } else{
                            Intent navegacion = new Intent(Login.this, CatalagoDeLibros.class);
                            startActivity(navegacion);
                        }
                    } else{
                        Toast.makeText(getApplicationContext(), "Usuario y/o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });



        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent navegacion = new Intent(Login.this, Registro.class);
                startActivity(navegacion);

            }

        });





    }
}