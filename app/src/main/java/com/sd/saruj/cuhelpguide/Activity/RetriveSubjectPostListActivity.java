package com.sd.saruj.cuhelpguide.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sd.saruj.cuhelpguide.Class.FacultyBuilderClass;
import com.sd.saruj.cuhelpguide.ModelClass.Faculty;
import com.sd.saruj.cuhelpguide.ModelClass.FacultyBuilderModel;
import com.sd.saruj.cuhelpguide.R;
import com.sd.saruj.cuhelpguide.Adapter.RetriveSubjectPostListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RetriveSubjectPostListActivity extends AppCompatActivity {

    //this is the JSON Data URL
    //make sure you are using the correct ip else it will not work
    private static final String URL_PRODUCTS = "http://192.168.1.5/android/CU_HELP_GUIDE/getAllDepartmentPost.php?subject=";

    //a list to store all the products
    List<FacultyBuilderModel> productList;

    //the recyclerview
    RecyclerView recyclerView;
    String subjectName;

    private RetriveSubjectPostListAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive);

        Intent intent = getIntent();
        subjectName = intent.getStringExtra("subjectName");

        Toolbar toolbar = findViewById(R.id.retrive_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(subjectName);

        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();


        loadProducts();
    }

    private void loadProducts() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS+subjectName,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);


                                productList.add(new FacultyBuilderClass()
                                        .setId(product.getInt("id"))
                                        .setTitle(product.getString("title"))
                                        .setDetails(product.getString("post"))
                                        .setType(product.getString("subject"))
                                        .build()
                                );
                            }

                            //creating adapter object and setting it to recyclerview
                            adapter = new RetriveSubjectPostListAdapter(RetriveSubjectPostListActivity.this, productList);
                            recyclerView.setAdapter(adapter);
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

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
