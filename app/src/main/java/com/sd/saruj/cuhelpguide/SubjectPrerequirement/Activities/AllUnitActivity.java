package com.sd.saruj.cuhelpguide.SubjectPrerequirement.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sd.saruj.cuhelpguide.JavaClass.Faculty;
import com.sd.saruj.cuhelpguide.R;
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Adapter.AllUnitAdapter;

import java.util.ArrayList;
import java.util.List;

public class AllUnitActivity extends AppCompatActivity {


    List<Faculty> productList;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_unit);




        recyclerView = (RecyclerView) findViewById(R.id.allUnitRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        productList = new ArrayList<>();


        productList.add(
                new Faculty(
                        1,
                        "A Unit"

                )
        );
        productList.add(
                new Faculty(
                        2,
                        "B Unit"


                )
        );
        productList.add(
                new Faculty(
                        3,
                        "B1 Unit"


                )
        );

        productList.add(
                new Faculty(
                        4,
                        "C Unit"


                )
        );

        productList.add(
                new Faculty(
                        6,
                        "D Unit"


                )
        );

        productList.add(
                new Faculty(
                        7,
                        "D1 Unit"


                )
        );



        AllUnitAdapter adapter = new AllUnitAdapter(this, productList);
        recyclerView.setAdapter(adapter);


        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);





    }
}
