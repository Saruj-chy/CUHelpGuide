package com.sd.saruj.cuhelpguide.Activity;

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

import com.sd.saruj.cuhelpguide.Class.UnitSubjectViewClass;
import com.sd.saruj.cuhelpguide.Constant.DepartmentName;
import com.sd.saruj.cuhelpguide.Interfaces.UnitSubjectViewInterfaces;
import com.sd.saruj.cuhelpguide.ModelClass.Faculty;
import com.sd.saruj.cuhelpguide.R;
import com.sd.saruj.cuhelpguide.Adapter.UnitSubjectViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class UnitSubjectViewActivity extends AppCompatActivity {

    private List<Faculty> productList;
    private RecyclerView recyclerView;
    private EditText unitEdit;
    private UnitSubjectViewAdapter adapter;
    private GridLayoutManager manager;

    private UnitSubjectViewInterfaces mInterfaces ;

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
        mInterfaces = new UnitSubjectViewClass(this) ;

        Log.e("Unit", "unitname: "+unitName ) ;

        switch (unitName){
            case "A Unit":
                mInterfaces.getUnitName(DepartmentName.unit_A_Subj,unitName, productList);
                break;
            case "B Unit":
                mInterfaces.getUnitName(DepartmentName.unit_B_Subj,unitName, productList);
                break;
            case "B1 Unit":
                unitEdit.setVisibility(View.GONE);
                mInterfaces.getUnitName(DepartmentName.unit_B1_Subj,unitName, productList);
                break;
            case "C Unit":
                unitEdit.setVisibility(View.GONE);
                mInterfaces.getUnitName(DepartmentName.unit_C_Subj,unitName, productList);
                break;
            case "D1 Unit":
                unitEdit.setVisibility(View.GONE);
                mInterfaces.getUnitName(DepartmentName.unit_D1_Subj,unitName, productList);
                break;
            default:
                return;

        }
        adapter = new UnitSubjectViewAdapter(this, productList);
        recyclerView.setAdapter(adapter);


        manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        //===============   search option
        AddTextChange();


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
