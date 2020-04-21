package com.sd.saruj.cuhelpguide.SubjectPrerequirement.Activities;

import androidx.appcompat.app.AppCompatActivity;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_unit);

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
        productList.add(
                new Faculty(
                        0,
                        "Economics"

                )
        );
        productList.add(
                new Faculty(
                        0,
                        "Political Science"

                )
        );
        productList.add(
                new Faculty(
                        0,
                        "Sociology"

                )
        );
        productList.add(
                new Faculty(
                        0,
                        "Public Administration"

                )
        );
        productList.add(
                new Faculty(
                        0,
                        "Anthropology"

                )
        );
        productList.add(
                new Faculty(
                        0,
                        "International Relation"

                )
        );
        productList.add(
                new Faculty(
                        0,
                        "Communication and Journalism"

                )
        );
        productList.add(
                new Faculty(
                        0,
                        "Development Studies"

                )
        );
        productList.add(
                new Faculty(
                        0,
                        "Criminology and Police Science"

                )
        );
        productList.add(
                new Faculty(
                        0,
                        "Accounting"

                )
        );
        productList.add(
                new Faculty(
                        0,
                        "Management"

                )
        );

        productList.add(
                new Faculty(
                        0,
                        "Finance"

                )
        );

        productList.add(
                new Faculty(
                        0,
                        "Marketing"

                )
        );
        productList.add(
                new Faculty(
                        0,
                        "Human resource and Management"

                )
        );

        productList.add(
                new Faculty(
                        0,
                        "Banking and Insurance"

                )
        );

//===========================================    2
        productList.add(
                new Faculty(
                        1,
                        "Economics"


                )
        );


        productList.add(
                new Faculty(
                        1,
                        "Political Science "


                )
        );

        productList.add(
                new Faculty(
                        1,
                        "Sociology "


                )
        );

        productList.add(
                new Faculty(
                        1,
                        " Public Administration"


                )
        );


        productList.add(
                new Faculty(
                        1,
                        "Anthropology "


                )
        );

        productList.add(
                new Faculty(
                        1,
                        " International Relation"


                )
        );

        productList.add(
                new Faculty(
                        1,
                        "Communication and Journalism "


                )
        );

        productList.add(
                new Faculty(
                        1,
                        "Development Studies "


                )
        );


        productList.add(
                new Faculty(
                        1,
                        "Criminology and Police Science "


                )
        );

    //   =========================================               3
        productList.add(
                new Faculty(
                        2,
                        "Economics"


                )
        );

        productList.add(
                new Faculty(
                        2,
                        " Political Science"


                )
        );

        productList.add(
                new Faculty(
                        2,
                        " Sociology"


                )
        );

        productList.add(
                new Faculty(
                        2,
                        "Public Administration "


                )
        );

        productList.add(
                new Faculty(
                        2,
                        "Anthropology "


                )
        );

        productList.add(
                new Faculty(
                        2,
                        " International Relation"


                )
        );

        productList.add(
                new Faculty(
                        2,
                        "Communication and Journalism"


                )
        );

        productList.add(
                new Faculty(
                        2,
                        "Development Studies"


                )
        );

        productList.add(
                new Faculty(
                        2,
                        "Criminology and Police Science"


                )
        );

        productList.add(
                new Faculty(
                        2,
                        "Accounting"


                )
        );

        productList.add(
                new Faculty(
                        2,
                        "Management"


                )
        );

        productList.add(
                new Faculty(
                        2,
                        "Finance"


                )
        );

        productList.add(
                new Faculty(
                        2,
                        "Marketing"


                )
        );

        productList.add(
                new Faculty(
                        2,
                        "Geography and Environmental study"


                )
        );

        productList.add(
                new Faculty(
                        2,
                        "Psychology"


                )
        );



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
