package com.gsnathan.dailywarmups;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Gokul Swaminathan on 1/2/2018.
 */

public class ReverseStringActivity extends AppCompatActivity {

    private TextView stringOutput;
    private EditText stringInput;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revstring);

        stringOutput = (TextView) findViewById(R.id.stringView);
        stringInput = (EditText) findViewById(R.id.editString);


        findViewById(R.id.button_revString).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                try {
                                    Utils methods = new Utils(stringOutput);
                                    stringOutput.setText(methods.revString(stringInput.getText().toString()));
                                } catch (Exception E) {
                                    Context context = getApplicationContext();
                                    Utils.showToast(context, "Error", Toast.LENGTH_SHORT);
                                }
                            }
                        }
                );

        findViewById(R.id.button_clear2).setOnClickListener
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
