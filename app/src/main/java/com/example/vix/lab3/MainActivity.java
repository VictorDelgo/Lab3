package com.example.vix.lab3;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    Button B1;
    Button B2;
    Button B3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B1=findViewById(R.id.button);
        B2=findViewById(R.id.button2);
        B3=findViewById(R.id.button3);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "The phone is vibrating", Toast.LENGTH_LONG).show();


                long[] mVibratePattern = new long[]{0, 400, 200, 400};
                Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(mVibratePattern, -1);
            }
        });

        B2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intentC2=new Intent(MainActivity.this,Activity2.class);
                startActivity(intentC2);
            }
        });

        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder NotifBuilder = new NotificationCompat.Builder(MainActivity.this,"identity");

                NotifBuilder.setSmallIcon(R.mipmap.ic_launcher);
                NotifBuilder.setContentTitle("GG");
                NotifBuilder.setContentText("Presionaste un boton y te dio una notificacion");


                NotificationManager MyNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                String channelId="identity";
                CharSequence channelName = "Some Channel";
                int importance = NotificationManager.IMPORTANCE_LOW;
                NotificationChannel notificationChannel = new NotificationChannel(channelId,channelName,importance);
                MyNotification.createNotificationChannel(notificationChannel);

                MyNotification.notify(0,NotifBuilder.build());

            }
        });



    }
}
