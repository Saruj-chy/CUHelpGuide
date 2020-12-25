package com.sd.saruj.cuhelpguide.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.sd.saruj.cuhelpguide.ModelClass.Faculty;
import com.sd.saruj.cuhelpguide.R;
import com.sd.saruj.cuhelpguide.Adapter.SubjectReviewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SubjectReviewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private EditText mEditText ;
   private SubjectReviewAdapter mAdapter;
   private GridLayoutManager manager ;
   private List<Faculty> departmentList;

    String[] departmentName = {
            "Department of Accounting", "Department of Management", "Department of Finance", "Department of Marketing", "Human Resource Management", "Banking and Insurance",
            "Deparetment of CSE",   "Department of EEE",
            "Department of Zoology", "Department of Botany", "Department of Pharmacy", "Biochemistry and Molecular Biology", "Department of Microbiology", "Department of Soil Science", "Genetic Engineering and Biotechnology", "Department of Psychology", "Geography and Environmental Studies",
            "Deparetment of Forestry",  "Department of Environmental",
            "Deparetment of Marine",    "Department of Fisharies",
            "Department of Physics", "Department of Chemistry", "Department of Mathematics", "Department of Statistics", "Applied Chemistry and Chemical Engineering",
            "Department of Bangla", "Department of English", "Department of History", "Department of Philosophy", "Department of Islamic History and Culture",
            "Deparetment of Economics", "Department of Political Science", "Department of Sociology", "Department of Public Administration", "Communication and Journalism", "Criminology and Police Science", "Deparetment of Economics", "Department of Political Science", "Department of Sociology", "Department of Public Administration", "Communication and Journalism", "Criminology and Police Science",
            "Law",
            "All Subject"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_post);

        Toolbar toolbar = findViewById(R.id.department_post_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle("Subject Review");

        mRecyclerView = findViewById(R.id.departmentRecyclerView);
        mEditText = findViewById(R.id.departmentEditText);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        departmentList = new ArrayList<>();

        for(int i=0; i<departmentName.length; i++){
            departmentList.add(
                    new Faculty(
                            i+1,
                            departmentName[i]
                    )
            );
        }

        mAdapter = new SubjectReviewAdapter(this, departmentList);
        mRecyclerView.setAdapter(mAdapter);


        manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);

        //===============   search option
        AddTextChange();


    }

    public void AddTextChange(){
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                List<Faculty> filteredList = new ArrayList<>();

                for (Faculty item : departmentList) {

                    if (item.getName().toLowerCase().contains(s.toString().toLowerCase())){
                        filteredList.add(item);
                    }
                }

                mAdapter.filterList(filteredList);
            }
        });
        mEditText.setText("");
    }

}
