package com.gsnathan.dailywarmups;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Gokul Swaminathan on 1/5/2018.
 */

public class ForumActivity extends AppCompatActivity
{
    private EditText idea;
    private EditText why;
    private EditText comments;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        idea = (EditText) findViewById(R.id.editIdea);
        why = (EditText) findViewById(R.id.editWhy);
        comments = (EditText) findViewById(R.id.editComments);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/")
                .build();
        final ForumSpreadsheetWebService spreadsheetWebService = retrofit.create(ForumSpreadsheetWebService.class);


        findViewById(R.id.submitForum).setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        String ideasIn = idea.getText().toString();
                        String whyIn = why.getText().toString();
                        String comIn = comments.getText().toString();

                        Call<Void> completeQuestionnaireCall = spreadsheetWebService.completeQuestionnaire(ideasIn, whyIn, comIn);
                        completeQuestionnaireCall.enqueue(callCallback);


                    }
                }
        );


    }

    private final Callback<Void> callCallback = new Callback<Void>() {
        @Override
        public void onResponse(Call<Void> call, Response<Void> response) {
            Log.d("XXX", "Submitted. " + response);
            clear();
            Context context = getApplicationContext();
            Utils.showToast(context,"Thanks for the feedback!", Toast.LENGTH_SHORT);
        }

        @Override
        public void onFailure(Call<Void> call, Throwable t) {
            Log.e("XXX", "Failed", t);
            Context context = getApplicationContext();
            Utils. showToast(context,"Try submitting the feedback again", Toast.LENGTH_SHORT);
        }
    };

    private void clear()
    {
        idea.setText("");
        why.setText("");
        comments.setText("");
    }
}
