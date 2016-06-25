package com.example.nuni.ldh1;

/**
 * Created by Samuel on 21/06/2016.
 */
    import android.net.Uri;
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

    import com.google.android.gms.appindexing.Action;
    import com.google.android.gms.appindexing.AppIndex;
    import com.google.android.gms.common.api.GoogleApiClient;

public class Nfc extends AppCompatActivity {
    private TextView text;
    private final static String sinNFC = "Su dispositivo no tiene NFC";
    private final static String conNFC = "Su dispositivo tiene NFC";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_nfc);
        text = (TextView) findViewById(R.id.textView6);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }


        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);

           if (nfcAdapter == null) {
               text.setText(sinNFC);

           }else {
               text.setText(conNFC);
               if (nfcAdapter != null && nfcAdapter.isEnabled()) {
                    Toast.makeText(this, "NFC ACTIVADO", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "NFC NO ACTIVADO ", Toast.LENGTH_LONG).show();
               }
           }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client.connect();
      //  Action viewAction = Action.newAction(
        //        Action.TYPE_VIEW, // TODO: choose an action type.
          //      "Nfc Page", // TODO: Define a title for the content shown.
            //    // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
             //   Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
               // Uri.parse("android-app://com.example.nuni.ldh1/http/host/path")
       // );
        //AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
       // Action viewAction = Action.newAction(
         //       Action.TYPE_VIEW, // TODO: choose an action type.
                //"Nfc Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                //Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                //Uri.parse("android-app://com.example.nuni.ldh1/http/host/path")
       // );
       // AppIndex.AppIndexApi.end(client, viewAction);
        //client.disconnect();
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


