package com.sd.saruj.cuhelpguide.Faculty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.JavaClass.EngineeringAdapter;
import com.sd.saruj.cuhelpguide.JavaClass.Faculty;
import com.sd.saruj.cuhelpguide.JavaClass.RecyclerViewAdapter;
import com.sd.saruj.cuhelpguide.R;

import java.util.ArrayList;
import java.util.List;


public class Engineering_Activity extends AppCompatActivity {

    List<Faculty> productList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineering_);

        Intent intent = getIntent();
        String facultyName = intent.getStringExtra("name");
       setTitle(facultyName);

        recyclerView = (RecyclerView) findViewById(R.id.engineerRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        productList = new ArrayList<>();


        productList.add(
                new Faculty(
                        1,
                        "Deparetment of CSE"

                )
        );
        productList.add(
                new Faculty(
                        2,
                        "Department of EEE"


                )
        );



        EngineeringAdapter adapter = new EngineeringAdapter(this, productList);
        recyclerView.setAdapter(adapter);


        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);







    }


}