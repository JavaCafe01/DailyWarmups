package com.gsnathan.dailywarmups;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Gokul Swaminathan on 1/3/2018.
 */

public class KnightActivity extends AppCompatActivity {
    private TextView stringOutput;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knight);

        stringOutput = (TextView) findViewById(R.id.textKnight);

        findViewById(R.id.button_moveKnight).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                stringOutput.setText("");
                                Utils methods = new Utils(stringOutput);
                                methods.knightClient();
                            }
                        }
                );
    }
}