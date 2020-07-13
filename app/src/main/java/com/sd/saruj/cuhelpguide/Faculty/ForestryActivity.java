package com.sd.saruj.cuhelpguide.Faculty;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.sd.saruj.cuhelpguide.JavaClass.EngineeringAdapter;
import com.sd.saruj.cuhelpguide.JavaClass.Faculty;
import com.sd.saruj.cuhelpguide.JavaClass.ForestryAdapter;
import com.sd.saruj.cuhelpguide.R;

import java.util.ArrayList;
import java.util.List;

public class ForestryActivity extends AppCompatActivity {

    List<Faculty> productList;
    RecyclerView recyclerView;

    String[] DepartmentName = {
            "Deparetment of Forestry",
            "Department of Environmental"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forestry);

        Intent intent = getIntent();
        String facultyName = intent.getStringExtra("name");
        setTitle(facultyName);

        Toolbar toolbar = findViewById(R.id.forestry_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(facultyName);

        recyclerView = (RecyclerView) findViewById(R.id.forestryRecyclerView);
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

        ForestryAdapter adapter = new ForestryAdapter(this, productList);
        recyclerView.setAdapter(adapter);


        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }
}
