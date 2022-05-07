package com.example.biblioteca;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

public class CatalagoDeLibros extends AppCompatActivity {
     TableLayout tlLibros;
     private Button btnNotificaciones;
     private Button btnNS;
     private static final String CHANNEL_ID= "Canal";
     private PendingIntent pendingIntent;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalago_de_libros);
        this.btnNotificaciones = findViewById(R.id.btnAgregar);
        btnNS = findViewById(R.id.btnSN);
        //this.tlLibros = findViewById(R.id.tlLibros);





        btnNS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                    showNotification();
                } else {
                    showNewNotification();
                }


            }
        });





        btnNotificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent naveg = new Intent( CatalagoDeLibros.this, notificaciones.class);
                startActivity(naveg);
            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showNotification() {


        NotificationChannel channel= new NotificationChannel(CHANNEL_ID,
                "NEW", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);
        showNewNotification();



    }


    private void showNewNotification(){
        setPendingIntent(notificaciones.class);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Libreria").setContentText("Debera entregar el libro en 3 dias ")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent);
        NotificationManagerCompat managerCompat= NotificationManagerCompat.from(getApplicationContext()); managerCompat.notify(1, builder.build());
    }
    private void setPendingIntent(Class<?> notificaciones){
        Intent intent = new Intent (this, notificaciones);
        TaskStackBuilder stackBuilder= TaskStackBuilder.create(this);
        stackBuilder.addParentStack(notificaciones);
        stackBuilder.addNextIntent(intent);
        pendingIntent= stackBuilder.getPendingIntent(1, PendingIntent.FLAG_UPDATE_CURRENT);


    }



    public void llenartabla(){

    }
}