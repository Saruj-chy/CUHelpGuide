package com.sd.saruj.cuhelpguide.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sd.saruj.cuhelpguide.ModelClass.FacultyBuilderClass;
import com.sd.saruj.cuhelpguide.Constant.Config;
import com.sd.saruj.cuhelpguide.ModelClass.FacultyBuilderModel;
import com.sd.saruj.cuhelpguide.R;
import com.sd.saruj.cuhelpguide.Adapter.RetriveSubjectPostListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RetriveSubjectPostListActivity extends AppCompatActivity {

    //this is the JSON Data URL
    //make sure you are using the correct ip else it will not work

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

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.RETRIVE_POST_LIST_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Response", " response: "+ response) ;

                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject product = array.getJSONObject(i);
                                productList.add(new FacultyBuilderClass()
                                        .setId(product.getInt("id"))
                                        .setTitle(product.getString("title"))
                                        .setDetails(product.getString("post"))
                                        .setName(product.getString("subject"))
                                        .build()
                                );
                            }
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
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> parameters = new HashMap<String, String>();

                parameters.put("subject", subjectName);
                return parameters;
            }

        };

        Log.e("subject", " sub name: "+ subjectName) ;

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);

        HashMap<String, String> map = new HashMap<>() ;
        map.put("subject", subjectName) ;

//        AppController.getAppController().getAppNetworkController().makeRequest(Config.RETRIVE_POST_LIST_URL, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                try {
//                    //converting the string to json array object
//                    JSONArray array = new JSONArray(response);
//
//                    //traversing through all the object
//                    for (int i = 0; i < array.length(); i++) {
//
//                        //getting product object from json array
//                        JSONObject product = array.getJSONObject(i);
//
//
//                        productList.add(new FacultyBuilderClass()
//                                .setId(product.getInt("id"))
//                                .setTitle(product.getString("title"))
//                                .setDetails(product.getString("post"))
//                                .setType(product.getString("subject"))
//                                .build()
//                        );
//                    }
//
//                    //creating adapter object and setting it to recyclerview
//                    adapter = new RetriveSubjectPostListAdapter(RetriveSubjectPostListActivity.this, productList);
//                    recyclerView.setAdapter(adapter);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        },map ) ;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_volunteer, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.action_volunteer){
            startActivity(new Intent(getApplicationContext(), VolunteerStudentActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
