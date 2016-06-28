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
 *
 */
public class Nfc extends AppCompatActivity {

    TextView text; //se crea un TextView para insertar si tiene o no NFC
    private static final  String SNFC = "Su dispositivo no tiene NFC"; //string con el texto a mostrar
    private static final  String CNFC = "Su dispositivo tiene NFC";


    @Override
    /**
     *
     */
    protected void onCreate(Bundle savedInstanceState) {
        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_nfc);
        text = (TextView) findViewById(R.id.textView6); //se asigna el text al textView6 creado

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }


        //variable de tipo NfcAdapter
           if (nfcAdapter == null) {
               text.setText(SNFC);

           }else {
               text.setText(CNFC);
               if (nfcAdapter.isEnabled()) {
                   //empleamos un toast para mostrar por pantalla durante un tiempo la notificacion
                    Toast.makeText(this, "NFC ACTIVADO", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "NFC DESACTIVADO ", Toast.LENGTH_LONG).show();
               }
           }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.content_nfc, container, false);
            return rootView;
        }
    }

}


