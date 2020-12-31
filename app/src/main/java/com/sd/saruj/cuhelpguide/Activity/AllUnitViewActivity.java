package com.sd.saruj.cuhelpguide.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sd.saruj.cuhelpguide.Class.FacultyBuilderClass;
import com.sd.saruj.cuhelpguide.ModelClass.Faculty;
import com.sd.saruj.cuhelpguide.ModelClass.FacultyBuilderModel;
import com.sd.saruj.cuhelpguide.R;
import com.sd.saruj.cuhelpguide.Adapter.AllUnitViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class AllUnitViewActivity extends AppCompatActivity {


    private List<FacultyBuilderModel> productList;
    private RecyclerView recyclerView;
    private AllUnitViewAdapter adapter ;
    private GridLayoutManager manager ;

    private String[] unitName = {
            "A Unit",
            "B Unit",
            "B1 Unit",
            "C Unit",
            "D Unit",
            "D1 Unit"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_unit_view);

        Toolbar toolbar = findViewById(R.id.allUnit_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle("Subject Pre-Requirement");

        recyclerView = (RecyclerView) findViewById(R.id.allUnitRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        productList = new ArrayList<>();

//        for(int i=0; i<unitName.length; i++){
//            productList.add(
//                    new Faculty(
//                            i+1,
//                            unitName[i]
//                    )
//            );
//        }


        for(int i=0; i<unitName.length; i++){
            productList.add(new FacultyBuilderClass().setId(i+1).setName(unitName[i]).build());
        }


        adapter = new AllUnitViewAdapter(this, productList);
        recyclerView.setAdapter(adapter);

        manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }
}
