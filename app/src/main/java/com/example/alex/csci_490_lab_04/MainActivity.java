package com.example.alex.csci_490_lab_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webview = new WebView(this);
        setContentView(webview);
        webview.loadUrl("https://www.wikipedia.org");
        String url = getUsers("https://jsonplaceholder.typicode.com/users");
        Log.i("Test URl", url);

    }

    public String getUsers(String URL)  {
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
}
