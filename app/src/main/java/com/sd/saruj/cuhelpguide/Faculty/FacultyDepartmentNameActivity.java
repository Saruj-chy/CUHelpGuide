package com.sd.saruj.cuhelpguide.Faculty;

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
import com.sd.saruj.cuhelpguide.R;

import java.util.ArrayList;
import java.util.List;


public class FacultyDepartmentNameActivity extends AppCompatActivity {

    List<Faculty> productList;
    RecyclerView recyclerView;

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
                getDepartmentName(DepartmentName.EngineerDepartmentName, "Engineer");
                break;
            case "Faculty of Business Administration":
                getDepartmentName(DepartmentName.BusinesssDepartmentName, "Business");
                break;
            case "Faculty of Social Science":
                getDepartmentName(DepartmentName.SocialDepartmentName, "Social");
                break;
            case "Faculty of Science":
                getDepartmentName(DepartmentName.ScienceDepartmentName, "Science");
                break;
            case "Faculty of Arts and Humanities":
                getDepartmentName(DepartmentName.ArtsDepartmentName, "Arts");
                break;
            case "Faculty of Biology":
                getDepartmentName(DepartmentName.BiologicalDepartmentName, "Biology");
                break;
            case "Faculty of Marine Science":
                getDepartmentName(DepartmentName.MarineDepartmentName, "Forestry");
                break;
            case "Faculty of Forestry and Environment":
                getDepartmentName(DepartmentName.ForestryDepartmentName, "Forestry");
                break;
            default:
                return;
        }

        FacultyDepartmentNameAdapter adapter = new FacultyDepartmentNameAdapter(this, productList);
        recyclerView.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }

    private void getDepartmentName(String[] departmentNameList, String type) {
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