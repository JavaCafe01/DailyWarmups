package com.gsnathan.dailywarmups;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.codemybrainsout.ratingdialog.RatingDialog;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button_starsquare).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                navToStarsquare();
                            }
                        }
                );

        findViewById(R.id.button_revString).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                navToRevString();
                            }
                        }
                );

        findViewById(R.id.button_triangle).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                navToStarTriangle();
                            }
                        }
                );

        findViewById(R.id.button_piglatin).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                navToPiglatin();
                            }
                        }
                );

        findViewById(R.id.button_list).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                navToList();
                            }
                        }
                );

        findViewById(R.id.button_stringflip).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                navToFlip();
                            }
                        }
                );

        findViewById(R.id.button_source).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                navToSource();
                            }
                        }
                );

        findViewById(R.id.button_pigsource).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                navToPigSource();
                            }
                        }
                );

        findViewById(R.id.button_about).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                navToAbout();
                            }
                        }
                );

        findViewById(R.id.button_knight).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                navToKnight();
                            }
                        }
                );

        findViewById(R.id.button_knightsource).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                navToKnightSource();
                            }
                        }
                );

        findViewById(R.id.button_rate).setOnClickListener
                (
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                showRatingDialogue();
                            }
                        }
                );


    }


    /* Navigation */
    private void navToStarsquare() {
        Intent intent = new Intent(this, StarsquareActivity.class);
        startActivity(intent);
    }

    private void navToRevString() {
        Intent intent = new Intent(this, ReverseStringActivity.class);
        startActivity(intent);
    }

    private void navToStarTriangle() {
        Intent intent = new Intent(this, StartriangleActivity.class);
        startActivity(intent);
    }

    private void navToPiglatin() {
        Intent intent = new Intent(this, PiglatinActivity.class);
        startActivity(intent);
    }

    private void navToList() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    private void navToFlip() {
        Intent intent = new Intent(this, FlipHalvesActivity.class);
        startActivity(intent);
    }

    private void navToSource() {
        Intent intent = new Intent(this, SourceActivity.class);
        startActivity(intent);
    }

    private void navToPigSource() {
        Intent intent = new Intent(this, PigSourceActivity.class);
        startActivity(intent);
    }

    private void navToAbout() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    private void navToKnight() {
        Intent intent = new Intent(this, KnightActivity.class);
        startActivity(intent);
    }

    private void navToKnightSource() {
        Intent intent = new Intent(this, KnightSourceActivity.class);
        startActivity(intent);
    }

    private void showRatingDialogue() {
        final RatingDialog ratingDialog = new RatingDialog.Builder(this)
                .title("Would you like to rate?")
                .titleTextColor(R.color.black)
                .positiveButtonText("Not Now")
                .negativeButtonText("Never")
                .positiveButtonTextColor(R.color.colorBlueAccent)
                .negativeButtonTextColor(R.color.colorBlueAccent)
                .ratingBarColor(R.color.yellow)
                .playstoreUrl("https://play.google.com/store/apps/details?id=com.gsnathan.dailywarmups")
                .build();

        ratingDialog.show();

    }


}