package com.sd.saruj.cuhelpguide.SubjectPrerequirement.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

    String[] unitName = {
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
        setContentView(R.layout.activity_all_unit);

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

        for(int i=0; i<unitName.length; i++){
            productList.add(
                    new Faculty(
                            i+1,
                            unitName[i]
                    )
            );
        }

        AllUnitAdapter adapter = new AllUnitAdapter(this, productList);
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }
}
