package com.sd.saruj.cuhelpguide.Faculty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.JavaClass.ArtsAdapter;
import com.sd.saruj.cuhelpguide.JavaClass.BiologicalAdapter;
import com.sd.saruj.cuhelpguide.JavaClass.Faculty;
import com.sd.saruj.cuhelpguide.R;

import java.util.ArrayList;
import java.util.List;

public class Biological_Activity extends AppCompatActivity {
    List<Faculty> productList;
    RecyclerView recyclerView;

    String[] DepartmentName = {
            "Department of Zoology",
            "Department of Botany",
            "Department of Pharmacy",
            "Biochemistry and Molecular Biology",
            "Department of Microbiology",
            "Department of Soil Science",
            "Genetic Engineering and Biotechnology",
            "Department of Psychology",
            "Geography and Environmental Studies"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biological);
        Intent intent = getIntent();
        String facultyName = intent.getStringExtra("name");
        setTitle(facultyName);

        Toolbar toolbar = findViewById(R.id.biology_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(facultyName);


        recyclerView = (RecyclerView) findViewById(R.id.biologyRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        productList = new ArrayList<>();

        for(int i=0; i<DepartmentName.length; i++){
            productList.add(
                    new Faculty(
                            i+1,
                            DepartmentName[i]
                    )
            );
        }

        BiologicalAdapter adapter = new BiologicalAdapter(this, productList);
        recyclerView.setAdapter(adapter);


        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);






    }
}