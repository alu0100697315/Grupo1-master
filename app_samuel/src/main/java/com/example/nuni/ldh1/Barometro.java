package com.example.nuni.ldh1;

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.TextView;



public class Barometro extends AppCompatActivity implements SensorEventListener{

    private TextView pressView;

    SensorManager sensorManager;

    private Sensor sensor;

    private static final String FALLOSENSOR = "Tu dispositivo no tiene el sensor: BARÓMETRO.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_barometro);

        pressView = (TextView) findViewById(R.id.pressTxt);

        sensorManager = (SensorManager)getSystemService(Service.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);

        if (sensor == null) {
            pressView.setText(FALLOSENSOR);
        }
    }

    @Override
    protected void onResume() {

        super.onResume();
        sensorManager = (SensorManager)getSystemService(Service.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Método no implementado por el Grupo 1.
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        pressView.setText(" " + values[0]);
    }
}