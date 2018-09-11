package com.example.vix.lab3;


import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;


public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        final Sensor proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (proximitySensor == null) {
        }

        SensorEventListener proximitySensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.values[0] < proximitySensor.getMaximumRange()) {

                    AlertDialog.Builder SecondDialogConf = new AlertDialog.Builder(Activity2.this);

                    SecondDialogConf.setTitle("Muy cerca");
                    SecondDialogConf.setMessage("El sensor te detecto muy cerca");

                    SecondDialogConf.setNeutralButton("Salir", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog,int id){
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = SecondDialogConf.create();
                    dialog.show();

                }else{

                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }

        };
        sensorManager.registerListener(proximitySensorListener,proximitySensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
}
