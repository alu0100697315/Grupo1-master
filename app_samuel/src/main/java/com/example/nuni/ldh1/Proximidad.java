package com.example.nuni.ldh1;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Proximidad extends AppCompatActivity implements SensorEventListener {

    LinearLayout fondo;
    TextView texto;

    /**Sensor de proximidad**/
    Sensor sensor;
    SensorManager sensorM;

    private static final String FALLOSENSOR = "Su dispositivo no tiene el sensor : PROXIMIDAD.";

    /**
     *       Primero se le especifica a la clase ProximidadActivity que implemente el SensorEventListener, esto
     *  se hace para manipular los eventos del sensor y ejecutar nuestro código cuando cambie.
     *
     */

    /**
     * Constructor de la clase Activity,
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximidad);
        fondo = (LinearLayout) findViewById(R.id.fondo);
        this.texto =(TextView) findViewById(R.id.proximidad);

        sensorM = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorM.registerListener(this,sensor,sensorM.SENSOR_DELAY_UI);

        // Si no detectamos el sensor, mostramos el mensaje de fallo
        if (sensor == null) {
           texto.setText(FALLOSENSOR);
        }
    }
    /**
     *      El evento que interesa es OnSensorChanged, el código escrito en este evento se ejecuta cada vez que algún valor
     * de distancia cambia. Primero se captura en forma de número flotante el valor de proximidad del sensor. Si el número
     * que devuelve es menor o igual que 2.5 se activa la App cambiando el fondo de la misma a un color aleatorio,
     * en caso contrario se deja el color negro en la pantalla.
     *
     */

    @Override
    public void onSensorChanged(SensorEvent evento) {
        float valor=Float.parseFloat(String.valueOf(evento.values[0]));
        if (valor <= 2.5) {
            int red =(int) (Math.random()*255+1);
            int green =(int)(Math.random()*255+1);
            int blue =(int)(Math.random()*255+1);
            int color = Color.rgb(red, green, blue);
            fondo.setBackgroundColor(color);
        }
        else{
            fondo.setBackgroundColor(Color.BLACK);
        }

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
   //nada
    }
}