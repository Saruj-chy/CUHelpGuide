package com.sd.saruj.cuhelpguide.SubjectPrerequirement.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.sd.saruj.cuhelpguide.JavaClass.Faculty;
import com.sd.saruj.cuhelpguide.R;
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Adapter.AUnitAdapter;
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Adapter.AllUnitAdapter;

import java.util.ArrayList;
import java.util.List;

public class AUnitActivity extends AppCompatActivity {



    List<Faculty> productList;
    RecyclerView recyclerView;
    EditText unitEdit;

    AUnitAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_unit);


        unitEdit = findViewById(R.id.unitEdit);

        recyclerView = (RecyclerView) findViewById(R.id.UnitRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        productList = new ArrayList<>();


        productList.add(
                new Faculty(
                        1,
                        "Physics"

                )
        );
        productList.add(
                new Faculty(
                        2,
                        "Chemistry"


                )
        );
        productList.add(
                new Faculty(
                        3,
                        "Math"


                )
        );

        productList.add(
                new Faculty(
                        4,
                        "Statistics"


                )
        );

        productList.add(
                new Faculty(
                        6,
                        "Applied Chemistry and Chemical Engineering"


                )
        );

        productList.add(
                new Faculty(
                        7,
                        "Forestry"


                )
        );
        productList.add(
                new Faculty(
                        8,
                        "Environmental Science"


                )
        );

        productList.add(
                new Faculty(
                        9,
                        "Zoology"


                )
        );
        productList.add(
                new Faculty(
                        10,
                        "Botany"


                )
        );
        productList.add(
                new Faculty(
                        11,
                        "Geography and Environment Studies"


                )
        );
        productList.add(
                new Faculty(
                        12,
                        "Biochemistry"


                )
        );
        productList.add(
                new Faculty(
                        12,
                        "Microbiology"


                )
        );
        productList.add(
                new Faculty(
                        13,
                        "Soil Science"


                )
        );
        productList.add(
                new Faculty(
                        14,
                        "Genetic Engineering and Biotechnology"


                )
        );
        productList.add(
                new Faculty(
                        15,
                        "Psychology"


                )
        );
        productList.add(
                new Faculty(
                        16,
                        "Pharmacy"


                )
        );
        productList.add(
                new Faculty(
                        17,
                        "Computer Science and Engineering"


                )
        );
        productList.add(
                new Faculty(
                        18,
                        "Electrical and Electronic Engineering"


                )
        );
        productList.add(
                new Faculty(
                        19,
                        "Institute of Marine Science"


                )
        );
        productList.add(
                new Faculty(
                        20,
                        "Oceanography"


                )
        );
        productList.add(
                new Faculty(
                        21,
                        "Fisheries"


                )
        );




        adapter = new AUnitAdapter(this, productList);
        recyclerView.setAdapter(adapter);


        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
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
