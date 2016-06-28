package com.example.nuni.ldh1;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Clase que utiliza el sensor de temperatura del dispositivo y muestra por pantalla el valor obtenido
 * @author   Bianney Cabrera, Joshua García, Hilario Pérez y Antonio Suárez
 * @version  1.0
 */

public class Termometro extends AppCompatActivity implements SensorEventListener {

    // Declaracion de las variables que vamos a utilizar

    private TextView textoTemperaturaC, textoTemperaturaK, textoTemperaturaF ;
    private SensorManager mSensorManager;

    /**SEnsor de temperatura**/
    private Sensor sensor;
    private static final String FALLOSENSOR = "Su dispositivo no tiene el sensor: TEMPERATURA.";

    /**
     * Método que se ejecuta al lanzar la actividad.
     * Inicializa el Sensor, el SensorManager y establece un mensaje de error si no
     * se encuentra el sensor de temperatura.
     *  savedInstanceState Representa un buffer en el que se guarda el estado de la aplicación
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_termometro);

        // Asignamos los textViews que declaramos en el fichero activity_main a los que declaramos

        textoTemperaturaC = (TextView) findViewById(R.id.texto);
        textoTemperaturaK = (TextView) findViewById(R.id.textoKelvin);
        textoTemperaturaF = (TextView) findViewById(R.id.textoFarenheit);

        // Seleccionamos el sensor que lee la temperatura

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor= mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mSensorManager.registerListener(this, sensor,SensorManager.SENSOR_DELAY_NORMAL);

        // Si no detectamos el sensor, mostramos el mensaje de fallo

        if (sensor == null) {
            textoTemperaturaK.setText(FALLOSENSOR);
            textoTemperaturaK.setTextColor(Color.rgb(255, 0, 0));
        }
    }

    /**
     * Método que recoge el valor que detecta el sensor y lo actualiza en los TextViews cada vez que
     * se detecta un cambio en el sensor.
     *  event Parámetro que representa un cambio en el sensor de temperatura.
     */
    @Override
    public void onSensorChanged(SensorEvent event) {

        synchronized (this){
            if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE)
            {
                float temperatura = event.values[0];
                String temperaturaC = String.format("%.2f", temperatura);
                String temperaturaK = String.format("%.2f", temperatura + 273.15);
                String temperaturaF = String.format("%.2f", (temperatura * 1.8) + 32);
                textoTemperaturaC.setText("Temperatura 1: " + temperaturaC + "ºC");
                textoTemperaturaK.setText("Temperatura 2: " + temperaturaK + "ºK");
                textoTemperaturaF.setText("Temperatura 3: " + temperaturaF + "ºF");
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //nada
    }
}