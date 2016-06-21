package com.example.nuni.ldh1;

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
import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Prueba
 * @author SAMUEL RAFAEL DONIZ DOMINGUEZ
 * @author MIGUEL AURELIO GARCIA GONZALEZ
 * @author HECTOR JOSE RAVELO GARCIA
 * @author NURIA GONZALO SOTO
 */

/**
 * @class MainActivity
 */

public class MainActivity extends AppCompatActivity{

    /**
     * Creación de los botones en la interfaz principal
     *
     */

    /**
     * Grupo 1
     *
     * @button botonAcelerometro
     * @button botonGiroscopio
     * @button botonPodometro
     * @button botonBarometro
     */
    Button botonAcelerometro;
    Button botonGiroscopio;
    Button botonPodometro;

    /**
     * Grupo 2
     *
     * @button botonLUz
     * @button botonTermometro
     * @button botonPulsometro
     */
    Button botonLuz;
    Button botonTermometro;
    Button botonPulsometro;

    /**
     * Grupo 3
     *
     * @button botonHumedad
     * @button botonProximidad
     * @button botonMagnometro
     */
    Button botonHumedad;
    Button botonProximidad;
    Button botonMagnometro;


    /** The texto. */
    TextView texto;
    /** The sensor manager. */
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        texto = (TextView)findViewById(R.id.texto);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        //Muestra una lista de los sensores que tiene el dispositivo

        List<Sensor> mList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (int i=1 ; i<mList.size() ; i++) {
            texto.append("\n" + mList.get(i).getName() /*+ "\n" + mList.get(i).getVendor() + "\n" + mList.get(i).getVersion()*/);
        }

        /**
         * @author GRUPO1
         */

        /**
         * Se declara boton para el sensor ACELEROMETRO
         */
        botonAcelerometro = (Button) findViewById(R.id.button);
        botonAcelerometro.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                acelometer(v);
            }
        });

        /**
         * Se declara el boton para el sensor GIROSCOPIO
         */

        botonGiroscopio = (Button) findViewById(R.id.button2);
        botonGiroscopio.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                giroscopio(v);
            }
        });

        /**
         * Se declara boton para el sensor PODOMETRO
         */
        botonPodometro = (Button) findViewById(R.id.button3);
        botonPodometro.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                podometro(v);
            }
        });




        /**
         * Se declara boton para el sensor LUZ
         */
        botonLuz = (Button) findViewById(R.id.button8);
        botonLuz.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                luz(v);
            }
        });

        /**
         * Se declara boton para el sensor TERMOMETRO
         */
        botonTermometro = (Button) findViewById(R.id.button9);
        botonTermometro.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                termometro(v);
            }
        });

        /**
         * Se declara boton para el sensor PULSOMETRO
         */
        botonPulsometro = (Button) findViewById(R.id.button10);
        botonPulsometro.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                pulsometro(v);
            }
        });




        /**
         * @author Grupo3
         */
        /**
         * Se declara boton para el sensor HUMEDAD
         */
        botonHumedad = (Button) findViewById(R.id.button5);
        botonHumedad.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                humedad(v);
            }
        });

        /**
         * Se declara boton para el sensor PROXIMIDAD
         */
        botonProximidad = (Button) findViewById(R.id.button6);
        botonProximidad.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                proximidad(v);
            }
        });

        /**
         * Se declara boton para el sensor MAGNOMETRO
         */
        botonMagnometro = (Button) findViewById(R.id.button7);
        botonMagnometro.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                magnometro(v);
            }
        });




    }


    /**
     * Añade elementos a la barra de acción si está presente
     *
     * @param menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Coge el id , comprueba si está en los ajustes, si está return true, si no, retorna el item seleccionado en las opciones
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**********************************************************************************************
     * Grupo1
     *********************************************************************************************/

    /**
     * Función que crea el intent con la actividad del sensor acelerometro y la inicia.
     *
     * @param view
     */
    public void acelometer(View view) {
        Intent i = new Intent(this, Acelerometro.class);
        startActivity(i);
    }

    /**
     * Función que crea el intent con la actividad del sensor giroscopio y la inicia.
     *
     * @param view
     */
    public void giroscopio(View view) {
        Intent i = new Intent(this, Giroscopio.class);
        startActivity(i);
    }

    /**
     * Función que crea el intent con la actividad del sensor podometro y la inicia.
     *
     * @param view
     */
    public void podometro(View view) {
        Intent i = new Intent(this, Podometro.class);
        startActivity(i);
    }

    /*******************************************************************************************
     * Grupo 2
     ******************************************************************************************/

    /**
     * Función que crea el intent con la actividad del sensor humedad y la inicia.
     *
     * @param view
     */
    public void luz(View view) {
        Intent i = new Intent(this, Luz.class);
        startActivity(i);
    }

    /**
     * Función que crea el intent con la actividad del sensor humedad y la inicia.
     *
     * @param view
     */
    public void termometro(View view) {
        Intent i = new Intent(this, Termometro.class);
        startActivity(i);
    }

    /**
     * Función que crea el intent con la actividad del sensor humedad y la inicia.
     *
     * @param view
     */
    public void pulsometro(View view) {
        Intent i = new Intent(this, Pulsometro.class);
        startActivity(i);
    }


    /*******************************************************************************************
     * Grupo 3
     ******************************************************************************************/

    /**
     * Función que crea el intent con la actividad del sensor humedad y la inicia.
     *
     * @param view
     */
    public void humedad(View view) {
        Intent i = new Intent(this, Humedad.class);
        startActivity(i);
    }

    /**
     * Función que crea el intent con la actividad del sensor proximidad y la inicia.
     *
     * @param view
     */
    public void proximidad(View view) {
        Intent i = new Intent(this, Proximidad.class);
        startActivity(i);
    }

    /**
     * Función que crea el intent con la actividad del sensor magnometro y la inicia.
     *
     * @param view
     */
   public void magnometro(View view) {
        Intent i = new Intent(this, Magnometro.class);
        startActivity(i);

    }
}