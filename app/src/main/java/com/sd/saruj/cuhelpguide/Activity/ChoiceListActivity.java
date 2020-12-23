package com.sd.saruj.cuhelpguide.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.sd.saruj.cuhelpguide.Adapter.ChoiceListAdapter;
import com.sd.saruj.cuhelpguide.ModelClass.Faculty;
import com.sd.saruj.cuhelpguide.R;

import java.util.ArrayList;
import java.util.List;

public class ChoiceListActivity extends AppCompatActivity {

    String subCategory;
    List<Faculty> productList;
    RecyclerView recyclerView;
    private ChoiceListAdapter adapter ;

    String[] subName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_list);

        Toolbar toolbar = findViewById(R.id.choice_list_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle("Subject Choice List");

        Intent intent = getIntent();

        subCategory = intent.getExtras().getString("subCategory");

        recyclerView = (RecyclerView) findViewById(R.id.choicelistRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        productList = new ArrayList<>();

        switch (subCategory){
            case "Engineer":
                subName = getResources().getStringArray(R.array.subjectEngName);
                break;
            case "Biology":
                subName = getResources().getStringArray(R.array.subjectBioName);
                break;
        }



        for(int i=0; i<subName.length; i++){
            productList.add(
                    new Faculty(
                            i+1,
                            subName[i]

                    )
            );
        }
        

         adapter = new ChoiceListAdapter(this, productList);
        recyclerView.setAdapter(adapter);


        GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }
}
