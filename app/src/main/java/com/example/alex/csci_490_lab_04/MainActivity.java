package com.example.alex.csci_490_lab_04;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String url = "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = this.findViewById(R.id.textbox);
       /* WebView webview = new WebView(this);
        setContentView(webview);
        webview.loadUrl("https://www.wikipedia.org");*/
        doConn d = new doConn(t);
        d.execute("https://jsonplaceholder.typicode.com/users");
        try {
            url = d.get();
        }catch(Exception e){
            Log.i("error", e.getMessage());
        }
        Log.i("Test URl", url);

    }


    private class doConn extends AsyncTask<String, Void, String> {
        TextView txt;

        public doConn(TextView t){
            txt = t;
        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            Log.i("JSON", s);
            txt.setText(s);
        }


        @Override
        protected String doInBackground(String... URL) {
            URL source;
            try {
                source = new URL(URL[0]);
                URLConnection connection = source.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String retLine;
                StringBuilder sBuild = new StringBuilder();
                while ((retLine = br.readLine()) != null) {
                    sBuild.append(retLine);
                }

                Log.i("Test URl", sBuild.toString());
                return sBuild.toString();


            } catch (Exception e) {
                Log.i("Error", e.getMessage());

            }

            return "oops";


        }

    }
}



   /* public String getUsers extends AsyncTask<String, Void, String> {
        URL source;
        try {
            source = new URL(URL);
            URLConnection connection = source.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String retLine;
            StringBuilder sBuild = new StringBuilder();
            while ((retLine = br.readLine()) != null) {
                sBuild.append(retLine);
            }

            Log.i("Test URl", sBuild.toString());
            return sBuild.toString();


        } catch (Exception e) {
            Log.i("Error", e.getMessage());

        }

        return "oops";


    }
}*/
