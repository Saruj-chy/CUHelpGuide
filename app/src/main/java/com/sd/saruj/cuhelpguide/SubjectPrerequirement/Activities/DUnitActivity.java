package com.sd.saruj.cuhelpguide.SubjectPrerequirement.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.sd.saruj.cuhelpguide.JavaClass.Faculty;
import com.sd.saruj.cuhelpguide.R;
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Adapter.AUnitAdapter;
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Adapter.CUnitAdapter;
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Adapter.DUnitAdapter;

import java.util.ArrayList;
import java.util.List;

public class DUnitActivity extends AppCompatActivity {


    List<Faculty> productList;
    RecyclerView recyclerView;

    DUnitAdapter adapter;
    EditText unitEdit;

    Spinner mySpinner;
    String[] categories={"Science","Business Studies","Humanities "};
    String[] scienceSubject =
            {   "Economics",   "Political Science",    "Sociology",     "Public Administration",
            "Anthropology",     "International Relation",    "Communication and Journalism",    "Development Studies",
            "Criminology and Police Science",   "Accounting",   "Management",   "Finance",      "Marketing",
            "Human resource and Management",        "Banking and Insurance"
            };
    String[] commerceSubject =
            {  "Economics",  "Political Science ",   "Sociology ",   " Public Administration",
            "Anthropology ",    " International Relation",   "Communication and Journalism ",
            "Development Studies ",     "Criminology and Police Science "
            };
    String[] artsSubject =
            {    "Economics",   " Political Science",   " Sociology",   "Public Administration ",   "Anthropology ",
            " International Relation",  "Communication and Journalism",     "Development Studies",      "Criminology and Police Science",
            "Accounting",   "Management",   "Finance",      "Marketing",    "Geography and Environmental study",    "Psychology"
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_unit);

        Toolbar toolbar = findViewById(R.id.d_Unit_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle("Unit D");

        unitEdit = findViewById(R.id.unitEdit);

        recyclerView = (RecyclerView) findViewById(R.id.UnitRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mySpinner = findViewById(R.id.unitSpinner);
        mySpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories));

        //spinner selection events
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long itemID) {
                if (position >= 0 && position < categories.length) {
                    getSelectedCategoryData(position);
                } else {
                    Toast.makeText(getApplicationContext(), "Selected Category Does not Exist!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        productList = new ArrayList<>();

        for(int i=0; i<scienceSubject.length; i++){
            productList.add(
                    new Faculty(
                            0,
                            scienceSubject[i]
                    )
            );
        }
        for(int i=0; i<commerceSubject.length; i++){
            productList.add(
                    new Faculty(
                            1,
                            commerceSubject[i]
                    )
            );
        }
        for(int i=0; i<artsSubject.length; i++){
            productList.add(
                    new Faculty(
                            2,
                            artsSubject[i]
                    )
            );
        }

        adapter = new DUnitAdapter(this, productList);
        recyclerView.setAdapter(adapter);


        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

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

    //================================    getselect spinner
    private void getSelectedCategoryData(int categoryID) {
        //arraylist to hold selected cosmic bodies
        ArrayList<Faculty> product = new ArrayList<>();
      /*  if(categoryID == 0)
        {
            adapter = new DUnitAdapter(this, productList);
        }else{*/
            //filter by id
            for (Faculty faculty : productList) {
                if (faculty.getId() == categoryID) {
                    product.add(faculty);
                }
            }
            //instatiate adapter a
            adapter = new DUnitAdapter(this,  product);
      //  }
        //set the adapter to GridView
        recyclerView.setAdapter(adapter);
    }
}
