package com.sd.saruj.cuhelpguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.sd.saruj.cuhelpguide.Faculty.ArtsAndHumanities_Activity;
import com.sd.saruj.cuhelpguide.Faculty.Biological_Activity;
import com.sd.saruj.cuhelpguide.Faculty.Business_Activity;
import com.sd.saruj.cuhelpguide.Faculty.Engineering_Activity;
import com.sd.saruj.cuhelpguide.Faculty.Marine_Activity;
import com.sd.saruj.cuhelpguide.Faculty.Science_Activity;
import com.sd.saruj.cuhelpguide.Faculty.Social_Activity;
import com.sd.saruj.cuhelpguide.JavaClass.Faculty;
import com.sd.saruj.cuhelpguide.JavaClass.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class Faculty_MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;

    List<Faculty> productList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty__main);


        recyclerView = (RecyclerView) findViewById(R.id.facultyRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        productList = new ArrayList<>();


        productList.add(
                new Faculty(
                        1,
                        "Faculty of Engineering"

                )
        );
        productList.add(
                new Faculty(
                        2,
                        "Faculty of Business Administration"


                )
        );
        productList.add(
                new Faculty(
                        3,
                        "Faculty of Social Science"


                )
        );

        productList.add(
                new Faculty(
                        4,
                        "Faculty of Science"


                )
        );

        productList.add(
                new Faculty(
                        6,
                        "Faculty of Arts and Humanities"


                )
        );

        productList.add(
                new Faculty(
                        7,
                        "Faculty of Biology"


                )
        );

        productList.add(
                new Faculty(
                        8,
                        "Faculty of Marine Science"


                )
        );

        productList.add(
                new Faculty(
                        9,
                        "Faculty of Forestry and Environment"


                )
        );
        productList.add(
                new Faculty(
                        10,
                        "Faculty of LAW"


                )
        );


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, productList);
        recyclerView.setAdapter(adapter);


        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);






    }


}
