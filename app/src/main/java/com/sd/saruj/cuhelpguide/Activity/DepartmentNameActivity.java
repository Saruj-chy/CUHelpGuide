package com.sd.saruj.cuhelpguide.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.Class.DepartmentNameClass;
import com.sd.saruj.cuhelpguide.Constant.DepartmentName;
import com.sd.saruj.cuhelpguide.Adapter.DepartmentNameAdapter;
import com.sd.saruj.cuhelpguide.Interfaces.DepartmentNameInterfaces;
import com.sd.saruj.cuhelpguide.ModelClass.Faculty;
import com.sd.saruj.cuhelpguide.R;

import java.util.ArrayList;
import java.util.List;


public class DepartmentNameActivity extends AppCompatActivity {

    private List<Faculty> productList;
    private RecyclerView recyclerView;
    private DepartmentNameAdapter adapter ;
    private GridLayoutManager manager ;

    private DepartmentNameInterfaces mInterfaces ;

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
        mInterfaces = new DepartmentNameClass(this);

        switch (facultyName){
            case "Faculty of Engineering":
                mInterfaces.getAllDepartmentName(DepartmentName.EngineerDepartmentName, "Engineer", productList);
                break;
            case "Faculty of Business Administration":
                mInterfaces.getAllDepartmentName(DepartmentName.BusinesssDepartmentName, "Business", productList);
                break;
            case "Faculty of Social Science":
                mInterfaces.getAllDepartmentName(DepartmentName.SocialDepartmentName, "Social",productList);
                break;
            case "Faculty of Science":
                mInterfaces.getAllDepartmentName(DepartmentName.ScienceDepartmentName, "Science",productList);
                break;
            case "Faculty of Arts and Humanities":
                mInterfaces.getAllDepartmentName(DepartmentName.ArtsDepartmentName, "Arts",productList);
                break;
            case "Faculty of Biology":
                mInterfaces.getAllDepartmentName(DepartmentName.BiologicalDepartmentName, "Biology", productList);
                break;
            case "Faculty of Marine Science":
                mInterfaces.getAllDepartmentName(DepartmentName.MarineDepartmentName, "Forestry", productList);
                break;
            case "Faculty of Forestry and Environment":
                mInterfaces.getAllDepartmentName(DepartmentName.ForestryDepartmentName, "Forestry", productList);
                break;
            default:
                return;
        }

        adapter = new DepartmentNameAdapter(this, productList);
        recyclerView.setAdapter(adapter);
        manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }
//
//    @Override
//    public List<Faculty> getAllDepartmentName(String[] departmentNameList, String type, List<Faculty> productList) {
//        for(int i=0; i<departmentNameList.length; i++){
//            productList.add(
//                    new Faculty(
//                            i+1,
//                            departmentNameList[i],
//                            type
//                    )
//            );
//        }
//        return productList;
//    }
}