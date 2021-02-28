package com.sd.saruj.cuhelpguide.controller.Activity;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.sd.saruj.cuhelpguide.model.FacultyBuilderClass;
import com.sd.saruj.cuhelpguide.controller.Adapter.FacultyNameAdapter;
import com.sd.saruj.cuhelpguide.model.FacultyBuilderModel;
import com.sd.saruj.cuhelpguide.R;

import java.util.ArrayList;
import java.util.List;

public class FacultyNameActivity extends AppCompatActivity {

    private List<FacultyBuilderModel> productList;
    private RecyclerView recyclerView;
    private FacultyNameAdapter adapter ;

    String[] FacultyName = {"Faculty of Engineering",
            "Faculty of Business Administration",
            "Faculty of Social Science",
            "Faculty of Science",
            "Faculty of Arts and Humanities",
            "Faculty of Biology",
            "Faculty of Marine Science",
            "Faculty of Forestry and Environment",
            "Faculty of LAW"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_name);

        Toolbar toolbar = findViewById(R.id.faculty_main_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle("Faculty Information");


        recyclerView = (RecyclerView) findViewById(R.id.facultyRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        productList = new ArrayList<>();

        for(int i=0; i<FacultyName.length; i++){
            productList.add(new FacultyBuilderClass().setId(i+1).setName(FacultyName[i]).build());
        }

        adapter = new FacultyNameAdapter(this, productList);
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);


    }
}
