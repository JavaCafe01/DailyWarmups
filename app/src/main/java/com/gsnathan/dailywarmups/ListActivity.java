package com.gsnathan.dailywarmups;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gokul Swaminathan on 1/2/2018.
 */

public class ListActivity extends AppCompatActivity {

    private TextView stringOutput;
    private EditText stringInput;
    private ArrayList list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        stringOutput = (TextView) findViewById(R.id.listView);
        stringInput = (EditText) findViewById(R.id.editList);
        list = new ArrayList();

        findViewById(R.id.button_add).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                list.add(stringInput.getText().toString());
                                stringOutput.setText("" + list);
                            }
                        }
                );

        findViewById(R.id.button_clear5).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                list.clear();
                                stringInput.setText("");
                                stringOutput.setText("" + list);
                            }
                        }
                );

    }
}