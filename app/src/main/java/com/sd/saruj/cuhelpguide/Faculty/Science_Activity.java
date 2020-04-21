package com.sd.saruj.cuhelpguide.Faculty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.JavaClass.BusinessAdapter;
import com.sd.saruj.cuhelpguide.JavaClass.Faculty;
import com.sd.saruj.cuhelpguide.JavaClass.ScienceAdapter;
import com.sd.saruj.cuhelpguide.R;

import java.util.ArrayList;
import java.util.List;


public class Science_Activity extends AppCompatActivity {

    List<Faculty> productList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);

        Intent intent = getIntent();
        String facultyName = intent.getStringExtra("name");
        setTitle(facultyName);

        recyclerView = (RecyclerView) findViewById(R.id.scienceRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        productList = new ArrayList<>();


        productList.add(
                new Faculty(
                        1,
                        "Department of Physics"

                )
        );
        productList.add(
                new Faculty(
                        2,
                        "Department of Chemistry"


                )
        );

        productList.add(
                new Faculty(
                        3,
                        "Department of Mathematics"


                )
        );

        productList.add(
                new Faculty(
                        4,
                        "Department of Statistics"


                )
        );

        productList.add(
                new Faculty(
                        5,
                        "Applied Chemistry and Chemical Engineering"


                )
        );







        ScienceAdapter adapter = new ScienceAdapter(this, productList);
        recyclerView.setAdapter(adapter);


        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);







    }



}
