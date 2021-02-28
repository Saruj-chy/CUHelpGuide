package com.sd.saruj.cuhelpguide.controller.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sd.saruj.cuhelpguide.controller.Adapter.VolunteerStudentAdapter;
import com.sd.saruj.cuhelpguide.controller.Constant.Config;
import com.sd.saruj.cuhelpguide.model.FacultyBuilderClass;
import com.sd.saruj.cuhelpguide.model.FacultyBuilderModel;
import com.sd.saruj.cuhelpguide.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VolunteerStudentActivity extends AppCompatActivity {

    private RecyclerView mVolunteerRecycler;
    private Toolbar mVolunteerToolbar;

    public static List<FacultyBuilderModel> mVolunteerList;
    private VolunteerStudentAdapter mVolunteerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_student);


        mVolunteerToolbar = findViewById(R.id.volunteer_list_toolbar);
        setSupportActionBar(mVolunteerToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle("Volunteer Student List");

        mVolunteerRecycler = findViewById(R.id.recycler_volunteer_list) ;
        mVolunteerRecycler.setHasFixedSize(true);
        mVolunteerRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mVolunteerList = new ArrayList<>();
        mVolunteerAdapter = new VolunteerStudentAdapter(getApplicationContext(), mVolunteerList);
        mVolunteerRecycler.setAdapter(mVolunteerAdapter);

        loadProducts();

    }

    private void loadProducts() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.VOLUNTEER_STUDENT_LIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("TAG", "response:  "+ response ) ;
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray array = jsonObject.getJSONArray("data");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject product = array.getJSONObject(i);
                                mVolunteerList.add(new FacultyBuilderClass()
                                        .setName(product.getString("volunteer_name"))
                                        .setPhone(product.getString("volunteer_phn"))
                                        .setDepartment_name(product.getString("department_fullname"))
                                        .build());
                            }
                            mVolunteerAdapter.notifyDataSetChanged();

//                            Log.e("volunteer", mVolunteerList.size()+"  size") ;
//                            Toast.makeText(VolunteerStudentActivity.this, "size: "+ mVolunteerList.size(), Toast.LENGTH_SHORT).show();

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
                parameters.put("department_fullname", "CSE");
                return parameters;
            }

        };

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
