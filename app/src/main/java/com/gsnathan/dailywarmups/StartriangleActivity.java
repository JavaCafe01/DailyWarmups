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

public class StartriangleActivity extends AppCompatActivity {
    private EditText height;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startriangle);

        height = (EditText) findViewById(R.id.editHeight);
        output = (TextView) findViewById(R.id.triView);

        findViewById(R.id.button_MakeTri).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Context context = getApplicationContext();
                                try {
                                    int starheight = Integer.parseInt(height.getText().toString());
                                    Utils methods = new Utils(output);
                                    if (starheight > 100) {
                                        Utils.showToast(context, "Size must be less than 100", Toast.LENGTH_SHORT);
                                    } else {
                                        methods.makeTri(starheight);
                                    }
                                } catch (Exception E) {
                                    Utils.showToast(context, "Error", Toast.LENGTH_SHORT);
                                }
                            }
                        }
                );

        findViewById(R.id.button_clear3).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                output.setText("");
                                height.setText("");
                            }
                        }
                );

    }


}

