package com.sd.saruj.cuhelpguide;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.sd.saruj.cuhelpguide.JavaClass.Faculty;
import com.sd.saruj.cuhelpguide.JavaClass.FacultyMainRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Faculty_MainActivity extends AppCompatActivity {

    List<Faculty> productList;
    RecyclerView recyclerView;

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
        setContentView(R.layout.activity_faculty__main);

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
            productList.add(
                    new Faculty(
                            i+1,
                            FacultyName[i]
                    )
            );
        }

        FacultyMainRecyclerAdapter adapter = new FacultyMainRecyclerAdapter(this, productList);
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);


    }


}
