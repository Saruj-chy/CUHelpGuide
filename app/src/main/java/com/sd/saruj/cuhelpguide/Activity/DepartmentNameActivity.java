package com.sd.saruj.cuhelpguide.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.Constant.DepartmentName;
import com.sd.saruj.cuhelpguide.Adapter.DepartmentNameAdapter;
import com.sd.saruj.cuhelpguide.Interfaces.DepartmentNameInterfaces;
import com.sd.saruj.cuhelpguide.ModelClass.Faculty;
import com.sd.saruj.cuhelpguide.R;

import java.util.ArrayList;
import java.util.List;


public class DepartmentNameActivity extends AppCompatActivity implements DepartmentNameInterfaces {

    private List<Faculty> productList;
    private RecyclerView recyclerView;
    private DepartmentNameAdapter adapter ;
    private GridLayoutManager manager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_department_name);

        Intent intent = getIntent();
        String facultyName = intent.getStringExtra("name");
        Log.e("department", "name: "+ facultyName) ;

        Toolbar toolbar = findViewById(R.id.engineer_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(facultyName);

        recyclerView = (RecyclerView) findViewById(R.id.engineerRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        productList = new ArrayList<>();

        switch (facultyName){
            case "Faculty of Engineering":
                getAllDepartmentName(DepartmentName.EngineerDepartmentName, "Engineer");
                break;
            case "Faculty of Business Administration":
                getAllDepartmentName(DepartmentName.BusinesssDepartmentName, "Business");
                break;
            case "Faculty of Social Science":
                getAllDepartmentName(DepartmentName.SocialDepartmentName, "Social");
                break;
            case "Faculty of Science":
                getAllDepartmentName(DepartmentName.ScienceDepartmentName, "Science");
                break;
            case "Faculty of Arts and Humanities":
                getAllDepartmentName(DepartmentName.ArtsDepartmentName, "Arts");
                break;
            case "Faculty of Biology":
                getAllDepartmentName(DepartmentName.BiologicalDepartmentName, "Biology");
                break;
            case "Faculty of Marine Science":
                getAllDepartmentName(DepartmentName.MarineDepartmentName, "Forestry");
                break;
            case "Faculty of Forestry and Environment":
                getAllDepartmentName(DepartmentName.ForestryDepartmentName, "Forestry");
                break;
            default:
                return;
        }

        adapter = new DepartmentNameAdapter(this, productList);
        recyclerView.setAdapter(adapter);
        manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }

    @Override
    public void getAllDepartmentName(String[] departmentNameList, String type) {
        for(int i=0; i<departmentNameList.length; i++){
            productList.add(
                    new Faculty(
                            i+1,
                            departmentNameList[i],
                            type
                    )
            );
        }
    }
}