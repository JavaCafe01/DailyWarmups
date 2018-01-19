package com.gsnathan.dailywarmups;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Gokul Swaminathan on 1/2/2018.
 */

public class PiglatinActivity extends AppCompatActivity {
    private TextView stringOutput;
    private EditText stringInput;

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
        setContentView(R.layout.activity_piglatin);

        stringOutput = (TextView) findViewById(R.id.pigView);
        stringInput = (EditText) findViewById(R.id.editEnglish);


        findViewById(R.id.button_Trans).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                try {
                                    Utils methods = new Utils(stringOutput);
                                    stringOutput.setText(methods.transToPiglatin(stringInput.getText().toString()));
                                } catch (Exception E) {
                                    Context context = getApplicationContext();
                                    Utils.showToast(context, "Error", Toast.LENGTH_SHORT);
                                }
                            }
                        }
                );

        findViewById(R.id.button_clear4).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                stringOutput.setText("");
                                stringInput.setText("");
                            }
                        }
                );

    }
}


