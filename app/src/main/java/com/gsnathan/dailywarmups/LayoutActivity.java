package com.gsnathan.dailywarmups;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class LayoutActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecyclerViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_layout);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);


    }


    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new
                                                                          MyRecyclerViewAdapter.MyClickListener() {
                                                                              @Override
                                                                              public void onItemClick(int position, View v) {
                                                                                  Log.i(LOG_TAG, " Clicked on Item " + position);
                                                                                  switch (position) {
                                                                                      case 0:
                                                                                          Intent intent = new Intent(getApplicationContext(), StarsquareActivity.class);
                                                                                          startActivity(intent);
                                                                                          break;

                                                                                      case 1:
                                                                                          Intent intent1 = new Intent(getApplicationContext(), StartriangleActivity.class);
                                                                                          startActivity(intent1);
                                                                                          break;
                                                                                      case 2:
                                                                                          Intent intent2 = new Intent(getApplicationContext(), ReverseStringActivity.class);
                                                                                          startActivity(intent2);
                                                                                          break;
                                                                                      case 3:
                                                                                          Intent intent3 = new Intent(getApplicationContext(), PiglatinActivity.class);
                                                                                          startActivity(intent3);
                                                                                          break;
                                                                                      case 4:
                                                                                          Intent intent4 = new Intent(getApplicationContext(), ListActivity.class);
                                                                                          startActivity(intent4);
                                                                                          break;
                                                                                      case 5:
                                                                                          Intent intent5 = new Intent(getApplicationContext(), FlipHalvesActivity.class);
                                                                                          startActivity(intent5);
                                                                                          break;

                                                                                      case 6:
                                                                                          Intent intent8 = new Intent(getApplicationContext(), KnightActivity.class);
                                                                                          startActivity(intent8);
                                                                                          break;
                                                                                      case 7:
                                                                                          Intent intent9 = new Intent(getApplicationContext(), KnightSourceActivity.class);
                                                                                          startActivity(intent9);
                                                                                          break;
                                                                                      case 8:
                                                                                          Intent intent10 = new Intent(getApplicationContext(), AsciiActivity.class);
                                                                                          startActivity(intent10);
                                                                                          break;
                                                                                      case 9:
                                                                                          Intent intent11 = new Intent(getApplicationContext(), ForumActivity.class);
                                                                                          startActivity(intent11);
                                                                                          break;
                                                                                      case 10:
                                                                                          Intent intent12 = new Intent(getApplicationContext(), AboutActivity.class);
                                                                                          startActivity(intent12);
                                                                                          break;
                                                                                      default:
                                                                                          Context context = getApplicationContext();
                                                                                          Utils.showToast(context, "Error", Toast.LENGTH_SHORT);
                                                                                          break;
                                                                                  }


                                                                              }
                                                                          });
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();

        DataObject obj0 = new DataObject("Star Square",
                "");
        results.add(0, obj0);

        DataObject obj1 = new DataObject("Star Triangle",
                "");
        results.add(1, obj1);

        DataObject obj2 = new DataObject("Reverse String",
                "");
        results.add(2, obj2);

        DataObject obj3 = new DataObject("Pig Latin Translator",
                "");
        results.add(3, obj3);

        DataObject obj4 = new DataObject("Array List",
                "");
        results.add(4, obj4);

        DataObject obj5 = new DataObject("Flip Halves",
                "");
        results.add(5, obj5);

        DataObject obj6 = new DataObject("Knight's Tour",
                "Thanks to Andrew da Cunha");
        results.add(6, obj6);

        DataObject obj7 = new DataObject("Knight's Tour Source Code",
                "Thanks to Andrew da Cunha");
        results.add(7, obj7);

        DataObject obj8 = new DataObject("Character Map",
                "");
        results.add(8, obj8);

        DataObject obj9 = new DataObject("Feedback",
                "");
        results.add(9, obj9);

        DataObject obj10 = new DataObject("About Daily Warmups",
                "");
        results.add(10, obj10);

        return results;
    }





}