package com.example.nuni.ldh1;

/**
 * Created by Sergio on 10/12/2015.
 * @author Grupo 3
 */

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class Humedad extends Activity implements SensorEventListener {
    LinearLayout fondo;
    TextView texto;
    Sensor sensor;
    SensorManager sensorM;

    private static final  String FALLOSENSOR = "Su dispositivo no tiene el sensor: HUMEDAD.";

    /**
     *       Primero se le especifica a la clase HumedadActivity que implemente el SensorEventListener, esto
     *  se hace para manipular los eventos del sensor y ejecutar nuestro cÃ³digo cuando cambie.
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
        setContentView(R.layout.content_humedad);
        fondo = (LinearLayout) findViewById(R.id.fondo);
        texto = (TextView) findViewById(R.id.noSensor);

        sensorM = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorM.registerListener(this,sensor,sensorM.SENSOR_DELAY_UI);

        // Si no detectamos el sensor, mostramos el mensaje de fallo
        if (sensor == null) {
            texto.setText(FALLOSENSOR);
        }
    }

    /**
     *      El evento que interesa es OnSensorChanged, el cÃ³digo escrito en este evento se ejecuta cada vez que algÃºn valor
     * de la variable cambie. Se coge el valor del sensor y se muestran mediante un objeto TextView especificando
     * el valor del array le pertenece:
     *
     * Medida = evento.values[0]
     *
     * Por otro lado se realiza un cambio de color en el fondo, que parte rojo para valores bajos de humedad, e intercala
     * otros dos valores intermedios en la gama hasta llegar al azul cuando la humedad sumera el 75%.
     * @param evento
     */

    @Override
    public void onSensorChanged(SensorEvent evento) {
        float valor=Float.parseFloat(String.valueOf(evento.values[0]));
        int red = 255;
        int green = 255;
        int blue = 255;
        int color = Color.rgb(red, green, blue);

        if(valor <= 25) {
            fondo.setBackgroundColor(color);
            texto.setText(""+valor);
        }
        else
        if(valor <= 50 && valor > 25) {
            fondo.setBackgroundColor(color);
            texto.setText("" + valor);
        }
        else
        if(valor <= 75 && valor > 50) {
            fondo.setBackgroundColor(color);
            texto.setText("" + valor);
        }
        else
        if(valor > 75 && valor <= 100) {
            fondo.setBackgroundColor(color);
            texto.setText(""+valor);
        }

    }


    /**
     *
     * @param sensor
     * @param accuracy
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //nada
    }
}