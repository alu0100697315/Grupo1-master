package com.example.nuni.ldh1;

/**
 * Created by Samuel on 21/06/2016.
 */
    import android.support.v7.app.ActionBarActivity;
    import android.support.v7.app.ActionBar;
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
    import android.os.Build;

    public class Nfc extends AppCompatActivity {
        TextView texto;
        private final static String sinNFC = "Su dispositivo no tiene NFC.";
        private final static String conNFC = "Su dispositivo tiene NFC";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.content_nfc);
            texto = (TextView)findViewById(R.id.textView14);

            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new PlaceholderFragment())
                        .commit();
            }


            NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
           /*if (nfcAdapter.isEnabled()==false){
                texto.setText(sinNFC);
            }
            else texto.setText(conNFC);*/
            if(nfcAdapter!=null && nfcAdapter.isEnabled()){
                Toast.makeText(this, "NFC ACTIVADO", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "NFC NO ACTIVADO ", Toast.LENGTH_LONG).show();
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

        /**
         * A placeholder fragment containing a simple view.
         */
        public static class PlaceholderFragment extends Fragment {

            public PlaceholderFragment() {
            }

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
                View rootView = inflater.inflate(R.layout.content_nfc, container, false);
                return rootView;
            }
        }

    }


