package com.example.nuni.ldh1;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * Clase que utiliza el pulsometro del dispositivo y muestra por pantalla el valor obtenido.
 * @author   Bianney Cabrera, Joshua García, Hilario Pérez y Antonio Suárez.
 * @version  1.0
 */

public class Pulsometro extends AppCompatActivity {

    private TextView textoPulsaciones;
    private SensorManager mSensorManager;

    /**Sensor pulsómetro**/
    private Sensor sensor;
    private final static String falloSensor = "Su dispositivo no tiene el sensor : PULSÓMETRO.";

    /**
     * Método que se ejecuta al lanzar la actividad.
     * Inicializa el Sensor, el SensorManager y establece un mensaje de error si no
     * se encuentra el pulsometro.
     * @param savedInstanceState Representa un buffer en el que se guarda el estado de la aplicación
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
            textoPulsaciones.setText(falloSensor);
        }
    }

    /**
     * Método que recoge el valor que detecta el sensor y lo actualiza en los TextViews cada vez que
     * se detecta un cambio en el sensor.
     * @param event Parámetro que representa un cambio en el pulsómetro.
     */

    // @Override
    public void onSensorChanged(SensorEvent event) {

        synchronized (this){
            switch (event.sensor.getType()){
                case Sensor.TYPE_HEART_RATE:
                    float pulsaciones = event.values[0];
                    textoPulsaciones.setText("Pulsaciones: " + String.valueOf(pulsaciones));
                    break;
                default:
                    System.out.print("default");
                    break;
            }
        }
    }

    //  @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}
