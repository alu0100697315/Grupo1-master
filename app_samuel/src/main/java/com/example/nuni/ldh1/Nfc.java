package com.example.nuni.ldh1;

/**
 * Created by Samuel on 21/06/2016.
 */

    import android.support.v4.app.Fragment;
    import android.nfc.NfcAdapter;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.TextView;
    import android.widget.Toast;

/**
 * Clase que implementa el uso de NFC
 */
public class Nfc extends AppCompatActivity {

    TextView text; //se crea un TextView para insertar si tiene o no NFC
    private static final  String SNFC = "Su dispositivo no tiene NFC"; //string con el texto a mostrar
    private static final  String CNFC = "Su dispositivo tiene NFC";


    @Override
    /**
     * Metodo onCreate.
     * Se llama en la creación de la actividad
     * Se crean las distintas variables y se hacen las funciones principales del programa
     */
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_nfc);
        text = (TextView) findViewById(R.id.textView6); //se asigna el text al textView6 creado
        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this); //variable de tipo NfcAdapter
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }

           if (nfcAdapter == null) {
               text.setText(SNFC); //en caso de que no tenga NFC
           }else {
               text.setText(CNFC);
               if (nfcAdapter.isEnabled()) {
                   //empleamos un toast para mostrar por pantalla durante un tiempo la notificacion
                    Toast.makeText(this, "NFC ACTIVADO", Toast.LENGTH_LONG).show(); //EL ADAPTADOR ESTA ACTIVADO
                } else {
                    Toast.makeText(this, "NFC DESACTIVADO ", Toast.LENGTH_LONG).show(); //EL ADAPTADOR ESTA DESACTIVADO
               }
           }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        /**
         * inflate instancia un xml para poder añadirlo a una jerarquía de vistas.
         */
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            return inflater.inflate(R.layout.content_nfc, container, false);
        }
    }

    /**
     * Funcion creada para los test
     */
    public static String getCNFC() {
        return CNFC;
    }

    /**
     * Funcion creada para los test
     */
    public boolean  getContent() {
        if ((R.layout.content_nfc) != 0) return true;
        else return false;
    }

    public boolean TestContainer(){
        if ((R.id.container)!= 0) return true;
        else return false;
    }
}


