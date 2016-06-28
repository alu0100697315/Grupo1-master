package com.example.nuni.ldh1;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Clase que utiliza el pulsometro del dispositivo y muestra por pantalla el valor obtenido.

 */

public class Pulsometro extends AppCompatActivity {

    private TextView textoPulsaciones;
    private SensorManager mSensorManager;

    /**Sensor pulsómetro**/
    private Sensor sensor;
    private static final  String FALLOSENSOR = "Su dispositivo no tiene el sensor : PULSÓMETRO.";

    /**
     * Método que se ejecuta al lanzar la actividad.
     * Inicializa el Sensor, el SensorManager y establece un mensaje de error si no
     * se encuentra el pulsometro.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_pulsometro);

        // Asignamos los textViews que declaramos en el fichero activity_main a los que declaramos
        textoPulsaciones = (TextView) findViewById(R.id.texto);


        // Seleccionamos el sensor que lee las pulsaciones
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor= mSensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);

        // Si no detectamos el sensor, mostramos el mensaje de fallo
        if (sensor == null) {
            textoPulsaciones.setText(FALLOSENSOR);
        }
    }

    /**
     * Método que recoge el valor que detecta el sensor y lo actualiza en los TextViews cada vez que
     * se detecta un cambio en el sensor.
     */


    public void onSensorChanged(SensorEvent event) {

        synchronized (this){
            if (event.sensor.getType() == Sensor.TYPE_HEART_RATE)
            {
                float pulsaciones = event.values[0];
                textoPulsaciones.setText("Pulsaciones: " + pulsaciones);
            }
        }
    }


    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //nada
    }
}
