package com.sd.saruj.cuhelpguide.Faculty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biological);
        Intent intent = getIntent();
        String facultyName = intent.getStringExtra("name");
        setTitle(facultyName);


        recyclerView = (RecyclerView) findViewById(R.id.biologyRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        productList = new ArrayList<>();


        productList.add(
                new Faculty(
                        1,
                        "Department of Zoology"

                )
        );
        productList.add(
                new Faculty(
                        2,
                        "Department of Botany"


                )
        );

        productList.add(
                new Faculty(
                        3,
                        "Department of Pharmacy"



                )
        );

        productList.add(
                new Faculty(
                        4,
                        "Biochemistry and Molecular Biology"


                )
        );

        productList.add(
                new Faculty(
                        5,
                        "Department of Microbiology"


                )
        );

        productList.add(
                new Faculty(
                        5,
                        "Department of Soil Science"


                )
        );

        productList.add(
                new Faculty(
                        5,
                        "Genetic Engineering and Biotechnology"


                )
        );

        productList.add(
                new Faculty(
                        5,
                        "Department of Psychology"


                )
        );

        productList.add(
                new Faculty(
                        5,
                        "Geography and Environmental Studies"


                )
        );




        BiologicalAdapter adapter = new BiologicalAdapter(this, productList);
        recyclerView.setAdapter(adapter);


        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);






    }
}