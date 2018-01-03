package com.gsnathan.dailywarmups;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by Gokul Swaminathan on 1/2/2018.
 */

public class FlipHalvesActivity  extends AppCompatActivity
{

    private TextView stringOutput;
    private EditText stringInput;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fliphalves);

        stringOutput = (TextView) findViewById(R.id.flipView);
        stringInput = (EditText) findViewById(R.id.editFlip);

        findViewById(R.id.button_flip).setOnClickListener
                (
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Utils methods = new Utils(stringOutput);
                                stringOutput.setText(methods.flipHalve(stringInput.getText().toString()));
                            }
                        }
                );

        findViewById(R.id.button_clear6).setOnClickListener
                (
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                stringInput.setText("");
                                stringOutput.setText("");
                            }
                        }
                );

    }
}