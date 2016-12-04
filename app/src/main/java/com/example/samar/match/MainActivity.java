package com.example.samar.match;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Data> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MatchAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MatchAdapter(dataList, getApplicationContext());

        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMatchData();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Contact us at +91 124 400 8464", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private void prepareMatchData() {
        Data data = new Data("Samar", R.drawable.samar, "25 - DELHI");
        dataList.add(data);

        data = new Data("Nishant", R.drawable.img, "20 - LUCKNOW");
        dataList.add(data);

        data = new Data("Megha", R.drawable.img5, "21 - MUMBAI");
        dataList.add(data);

        data = new Data("Amrita", R.drawable.img6, "25 - JAIPUR");
        dataList.add(data);

        data = new Data("Haider", R.drawable.img4, "24 - AMRITSAR");
        dataList.add(data);

        data = new Data("Saheb", R.drawable.img2, "20 - UK");
        dataList.add(data);

        data = new Data("Ram", R.drawable.img3, "29 - DELHI");
        dataList.add(data);

        data = new Data("Erik", R.drawable.img, "22 - USA");
        dataList.add(data);

        data = new Data("Larry", R.drawable.profile, "30 - USA");
        dataList.add(data);

        data = new Data("Sandeep", R.drawable.profile, "28 - JAPAN");
        dataList.add(data);

        data = new Data("Vikrant", R.drawable.profile, "19 - DUBAI");
        dataList.add(data);

        data = new Data("Nikhil", R.drawable.profile, "20 - ISRAEL");
        dataList.add(data);

        data = new Data("Albus", R.drawable.profile, "23 - JAIPUR");
        dataList.add(data);

        data = new Data("Diggle", R.drawable.profile, "19 - LA");
        dataList.add(data);

        data = new Data("Oliver", R.drawable.profile, "24 - CHICAGO");
        dataList.add(data);

        data = new Data("Thea", R.drawable.profile, "23 - CUBA");
        dataList.add(data);

        saveArray();

        mAdapter.notifyDataSetChanged();
    }

    public void saveArray() {
        SharedPreferences prefs = getSharedPreferences("dataList", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        Gson gson = new Gson();
//        String jsonText = Prefs.getString("key", null);
//        String[] text = gson.fromJson(jsonText, String[].class);  //EDIT: gso to gson


//Set the values
        String jsonText = gson.toJson(dataList);
        editor.putString("key", jsonText);
        editor.commit();
    }
}