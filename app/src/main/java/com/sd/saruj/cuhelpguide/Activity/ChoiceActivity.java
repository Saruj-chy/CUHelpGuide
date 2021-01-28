package com.sd.saruj.cuhelpguide.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sd.saruj.cuhelpguide.Adapter.ChoiceListAdapter;
import com.sd.saruj.cuhelpguide.Adapter.NoticeListAdapter;
import com.sd.saruj.cuhelpguide.Class.FacultyBuilderClass;
import com.sd.saruj.cuhelpguide.Constant.Config;
import com.sd.saruj.cuhelpguide.Interfaces.NoticeClickInterfaces;
import com.sd.saruj.cuhelpguide.ModelClass.FacultyBuilderModel;
import com.sd.saruj.cuhelpguide.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ChoiceActivity extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private RecyclerView mChoiceRecyclerView;
    private GridLayoutManager mGridManager;
    private Toolbar mChoiceToolbar;

    private ChoiceListAdapter mChoiceAdapter;
    private List<FacultyBuilderModel> mChoiceList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        mChoiceToolbar = findViewById(R.id.toolbar_choice);
        setSupportActionBar(mChoiceToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle("Choice List");


        mChoiceRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_choice);
        mChoiceRecyclerView.setHasFixedSize(true);
        mChoiceRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mChoiceList = new ArrayList<>();

        loadAllChoiceList();

    }

    private void loadAllChoiceList() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Config.DEPARTMENT_TABLE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Log.e("TAG", "response:  "+ response ) ;
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray array = jsonObject.getJSONArray("result");

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);

                                //adding the product to product list
//                                mNoticeList.add(new Faculty(
//                                        product.getInt("notice_id"),
//                                        product.getString("notice_name"),
//                                        product.getString("notice_url")
//                                ));

                                mChoiceList.add(new FacultyBuilderClass()
                                        .setId(product.getInt("department_id"))
                                        .setName(product.getString("department_fullname"))
                                        .build());
//
                            }


                            changeAdapter() ;

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_choice, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.action_search){
           createPopDialog();
        }

        return true;
    }

    private void createPopDialog() {
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.choice_dialog, null);
        final Spinner unitSpin = view.findViewById(R.id.spinner_unit_dialog);
        final Spinner grpSpin = view.findViewById(R.id.spinner_priority_dialog);
        final LinearLayout mPriorityLinear = view.findViewById(R.id.linear_priority_dialog);

        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.show();

        unitSpin.setAdapter(new ArrayAdapter<String>(ChoiceActivity.this,R.layout.choice_list_color,
                R.id.dropdown,getResources().getStringArray(R.array.all_unit)));

        unitSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedClass = parent.getItemAtPosition(position).toString();

                switch (selectedClass){
                    case "A Unit":
                        grpSpin.setAdapter(new ArrayAdapter<String>(ChoiceActivity.this, R.layout.choice_list_color,
                                R.id.dropdown, getResources().getStringArray(R.array.a_unit)));
                        mPriorityLinear.setVisibility(View.VISIBLE);
                        break;

                    case "All Unit":
                        mPriorityLinear.setVisibility(View.GONE);
                        break;


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        grpSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedClass = parent.getItemAtPosition(position).toString();
                switch (selectedClass) {
                    case "Engineer":
                        loadSubjectList("Engineer");
                        dialog.dismiss();
                        break;
                    case "Biology":

                        loadSubjectList("Biology");
                        dialog.dismiss();
                        break;


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }

    private void loadSubjectList(String subCategory) {
        String[] subName;
        switch (subCategory){
            case "Engineer":
                subName = getResources().getStringArray(R.array.subjectEngName);
                break;
            case "Biology":
                subName = getResources().getStringArray(R.array.subjectBioName);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + subCategory);
        }

        mChoiceList.clear();

        for(int i=0; i<subName.length; i++){
            mChoiceList.add(
                    new FacultyBuilderClass().setId(i+1).setName(subName[i]).build()
            );
        }

       changeAdapter() ;
    }

    private void changeAdapter() {
        mChoiceAdapter = new ChoiceListAdapter(getApplicationContext(), mChoiceList);
        mChoiceRecyclerView.setAdapter(mChoiceAdapter);
        mGridManager = new GridLayoutManager(getApplicationContext(), 2, GridLayoutManager.VERTICAL, false);
        mChoiceRecyclerView.setLayoutManager(mGridManager);
        mChoiceAdapter.notifyDataSetChanged();
    }
}
