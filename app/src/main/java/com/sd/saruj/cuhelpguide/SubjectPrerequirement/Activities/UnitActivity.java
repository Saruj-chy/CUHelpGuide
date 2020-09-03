package com.sd.saruj.cuhelpguide.SubjectPrerequirement.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.sd.saruj.cuhelpguide.Constant.DepartmentName;
import com.sd.saruj.cuhelpguide.Faculty.Faculty;
import com.sd.saruj.cuhelpguide.R;
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Adapter.UnitAdapter;

import java.util.ArrayList;
import java.util.List;

public class UnitActivity extends AppCompatActivity {

    List<Faculty> productList;
    RecyclerView recyclerView;
    EditText unitEdit;
    UnitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);


        Intent intent = getIntent();
        String unitName = intent.getStringExtra("name");

        Toolbar toolbar = findViewById(R.id.a_Unit_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(unitName);

        unitEdit = findViewById(R.id.unitEdit);

        recyclerView = (RecyclerView) findViewById(R.id.UnitRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        productList = new ArrayList<>();

        Log.e("Unit", "unitname: "+unitName ) ;

        switch (unitName){
            case "A Unit":
                getUnitName(DepartmentName.unit_A_Subj,unitName);
                break;
            case "B Unit":
                getUnitName(DepartmentName.unit_B_Subj,unitName);
                break;
            case "B1 Unit":
                unitEdit.setVisibility(View.GONE);
                getUnitName(DepartmentName.unit_B1_Subj,unitName);
                break;
            case "C Unit":
                unitEdit.setVisibility(View.GONE);
                getUnitName(DepartmentName.unit_C_Subj,unitName);
                break;
            case "D1 Unit":
                unitEdit.setVisibility(View.GONE);
                getUnitName(DepartmentName.unit_D1_Subj,unitName);
                break;
            default:
                return;

        }
        adapter = new UnitAdapter(this, productList);
        recyclerView.setAdapter(adapter);


        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        //===============   search option
        AddTextChange();


    }

    private void getUnitName(String[] unitNameList, String type) {
        for(int i=0; i<unitNameList.length; i++){
            productList.add(
                    new Faculty(
                            i+1,
                            unitNameList[i],
                            type
                    )
            );
        }
    }




    public void AddTextChange(){
        unitEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });
    }

    //=====================
    private void filter(String text) {
        List<Faculty> filteredList = new ArrayList<>();

        for (Faculty item : productList) {

            if (item.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
            /*if(item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }*/
        }

        adapter.filterList(filteredList);
    }
}
