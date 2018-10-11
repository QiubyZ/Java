package zhukhi.qiuby.jsoupdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;


public class MainActivity extends AppCompatActivity {
    private EditText stambuk;
    private EditText password;
    private Button button3;
    private TextView output;
    private String user, pass;
    private String url = "http://siakad.uho.ac.id/index.php?exec=login";

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stambuk = (EditText) findViewById(R.id.stambuk);
        password = (EditText) findViewById(R.id.password);
        button3 = (Button) findViewById(R.id.button3);
        output = (TextView) findViewById(R.id.Textview1);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                new doit().execute();
            }
        });
    }

    public class doit extends AsyncTask<Void, Void, Void>{
        String worlds;
        @Override
        protected Void doInBackground ( Void... voids ) {
            try {
                org.jsoup.nodes.Document doc = Jsoup.connect("http://google.om").get();
                this.worlds = doc.text();
            }catch (Exception e){e.printStackTrace();}

            return null;
        }

        @Override
        protected void onPostExecute ( Void aVoid ) {
            super.onPostExecute(aVoid);
            output.setText(worlds);
        }
    }

}



