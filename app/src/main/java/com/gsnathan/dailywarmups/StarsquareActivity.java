package com.gsnathan.dailywarmups;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Gokul Swaminathan on 1/1/2018.
 */

public class StarsquareActivity extends AppCompatActivity {

    private EditText size;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starsquare);

        size = (EditText) findViewById(R.id.editSize);
        output = (TextView) findViewById(R.id.tableView);

        findViewById(R.id.button_MakeTable).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int starsize = Integer.parseInt(size.getText().toString());
                                Context context = getApplicationContext();
                                try {
                                    Utils methods = new Utils(output);
                                    if (starsize > 100) {
                                        Utils.showToast(context, "Size must be less than 100", Toast.LENGTH_SHORT);
                                    } else {
                                        methods.makeSquare(starsize);
                                    }
                                } catch (Exception E) {

                                    Utils.showToast(context, "Error", Toast.LENGTH_SHORT);
                                }
                            }
                        }
                );

        findViewById(R.id.button_clear).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                output.setText("");
                                size.setText("");
                            }
                        }
                );

    }
}
