package com.example.nuni.ldh1;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class Magnometro extends AppCompatActivity implements SensorEventListener {
    private TextView magneticView;
    private Sensor s;
    private SensorManager sensorM;
    List<Sensor> sensores;

    /**
     *       Primero se le especifica a la clase MagnometroActivity que implemente el SensorEventListener, esto
     *  se hace para manipular los eventos del sensor y ejecutar nuestro código cuando cambie.
     *  @param savedInstanceState
     *
     */

    /**
     * Constructor de la clase Activity,
     * @param savedInstanceState guarda una instancia de la actividad pasada por parametro
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_magnometro);
        this.magneticView = (TextView) findViewById(R.id.magnetic);

        sensorM = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensores = sensorM.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        if (!sensores.isEmpty()){
            s = sensores.get(0);
            sensorM.registerListener(this,s,sensorM.SENSOR_DELAY_UI);
        }
        else {
            this.magneticView.setText("NO HAY SENSOR ACTIVO");
            this.magneticView.setBackgroundColor(Color.rgb(255, 0, 0));
        }
    }
    /**
     *      El evento que interesa es OnSensorChanged, el código escrito en este evento se ejecuta cada vez que algún valor
     * de las coordenadas cambien. Se cogen las coordenadas X, Y y Z del sensor y se muestran mediante un objeto TextView especificando
     * el valor del array le pertenece:
     * X = evento.values[0]
     * Y = evento.values[1]
     * Z = evento.values[2]
     * @param event
     */

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x,y,z;
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];
        magneticView.setText("Coordenada X:" + x + "Coordenada Y:" + y + "Coordenada Z:" + z );
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //nada
    }
}