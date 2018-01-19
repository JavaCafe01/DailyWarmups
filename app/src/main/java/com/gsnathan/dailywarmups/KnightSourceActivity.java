package com.gsnathan.dailywarmups;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Gokul Swaminathan on 1/3/2018.
 */

public class KnightSourceActivity extends AppCompatActivity {

    private StringBuilder text = new StringBuilder();

    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences pref = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean useDarkTheme = pref.getBoolean("dark_theme", false);
        if(useDarkTheme)
        {
            setTheme(R.style.DarkTheme);
        }
        else
        {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knightsource);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("knightsourcecode.txt")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                text.append(mLine);
                text.append('\n');
            }
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Error reading file!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }

            TextView output = (TextView) findViewById(R.id.knightsourceView);
            output.setText((CharSequence) text);

        }
    }
}