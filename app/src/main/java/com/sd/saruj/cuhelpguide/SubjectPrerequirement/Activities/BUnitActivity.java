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
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Adapter.BUnitAdapter;

import java.util.ArrayList;
import java.util.List;

public class BUnitActivity extends AppCompatActivity {


    List<Faculty> productList;
    RecyclerView recyclerView;
    BUnitAdapter adapter;
    EditText unitEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_unit);


        unitEdit = findViewById(R.id.unitEdit);

        recyclerView = (RecyclerView) findViewById(R.id.UnitRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        productList = new ArrayList<>();


        productList.add(
                new Faculty(
                        1,
                        "Bangla"

                )
        );
        productList.add(
                new Faculty(
                        2,
                        "English"


                )
        );
        productList.add(
                new Faculty(
                        3,
                        "History"


                )
        );

        productList.add(
                new Faculty(
                        4,
                        "Islamic History and Culture"


                )
        );
        productList.add(
                new Faculty(
                        5,
                        "Farsi Language and Literature"


                )
        );

        productList.add(
                new Faculty(
                        6,
                        "Language and Linguistics"


                )
        );

        productList.add(
                new Faculty(
                        7,
                        "Paali"


                )
        );
        productList.add(
                new Faculty(
                        8,
                        "Sanskrit"


                )
        );
        productList.add(
                new Faculty(
                        9,
                        "Institute of Education and Research"


                )
        );
        productList.add(
                new Faculty(
                        10,
                        "Bangladesh Studies"


                )
        );
        productList.add(
                new Faculty(
                        11,
                        "Philosophy"


                )
        );
        productList.add(
                new Faculty(
                        12,
                        "Arabic"


                )
        );
        productList.add(
                new Faculty(
                        13,
                        "Islamic Studies"


                )
        );



        adapter = new BUnitAdapter(this, productList);
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
}
