package com.example.nuni.ldh1;

/**
 * Created by Samuel on 21/06/2016.
 */

    import android.support.v4.app.Fragment;
    import android.nfc.NfcAdapter;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.view.LayoutInflater;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.TextView;
    import android.widget.Toast;


public class Nfc extends AppCompatActivity {

    private TextView text; //se crea un TextView para insertar si tiene o no NFC
    private final static String sinNFC = "Su dispositivo no tiene NFC"; //string con el texto a mostrar
    private final static String conNFC = "Su dispositivo tiene NFC";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_nfc);
        text = (TextView) findViewById(R.id.textView6); //se asigna el text al textView6 creado

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }


        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this); //variable de tipo NfcAdapter
           if (nfcAdapter == null) {
               text.setText(sinNFC);

           }else {
               text.setText(conNFC);
               if (nfcAdapter != null && nfcAdapter.isEnabled()) {
                   //empleamos un toast para mostrar por pantalla durante un tiempo la notificacion
                    Toast.makeText(this, "NFC ACTIVADO", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "NFC NO ACTIVADO ", Toast.LENGTH_LONG).show();
               }
           }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.content_nfc, container, false);
            return rootView;
        }
    }

}


