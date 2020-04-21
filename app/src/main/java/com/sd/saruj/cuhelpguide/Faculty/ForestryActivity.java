package com.sd.saruj.cuhelpguide.Faculty;

import androidx.appcompat.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forestry);

        Intent intent = getIntent();
        String facultyName = intent.getStringExtra("name");
        setTitle(facultyName);

        recyclerView = (RecyclerView) findViewById(R.id.forestryRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        productList = new ArrayList<>();


        productList.add(
                new Faculty(
                        1,
                        "Deparetment of Forestry"

                )
        );
        productList.add(
                new Faculty(
                        2,
                        "Department of Environmental"


                )
        );



        ForestryAdapter adapter = new ForestryAdapter(this, productList);
        recyclerView.setAdapter(adapter);


        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);







    }
}
