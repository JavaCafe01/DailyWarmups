package com.gsnathan.dailywarmups;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * Created by Gokul Swaminathan on 1/5/2018.
 */

public class AsciiActivity extends AppCompatActivity {

    ListView listAscii;
    AsciiCode Asciis[];
    ArrayAdapter<AsciiCode> asciiArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ascii);
        listAscii = (ListView) findViewById(R.id.asciilist);
        initAsciis();

        asciiArrayAdapter = new ArrayAdapter<AsciiCode>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, Asciis);
        listAscii.setAdapter(asciiArrayAdapter);
    }

    private void initAsciis() {
        Asciis = new AsciiCode[128];
        for (int i = 0; i < 128; i++) {
            Asciis[i] = new AsciiCode(i);
        }
    }

    class AsciiCode{
        int id;
        char charAscii;

        AsciiCode(int id){
            this.id = id;
            charAscii = (char)id;
        }

        public String toString(){
            return
                    String.format("%03d", id)
                            + " /(hex) 0x" + String.format("%02x", id).toUpperCase()
                            + " : " + charAscii;
        }
    }
}