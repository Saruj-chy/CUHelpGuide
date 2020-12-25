package com.sd.saruj.cuhelpguide.DepartmentInformation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.sd.saruj.cuhelpguide.Constant.Config;
import com.sd.saruj.cuhelpguide.MainActivity;
import com.sd.saruj.cuhelpguide.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import static com.sd.saruj.cuhelpguide.R.string.science_chemistry;

public class DepartmentInformationActivity extends AppCompatActivity {
    TextView departmentText;
    ImageView departmentImage;
    String  departmentName;

    HashMap<String, ArrayList<DepartmentModel>> departmentList = new HashMap<>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_information);

        Intent intent = getIntent();
        departmentName = intent.getExtras().getString("department");

        Toolbar toolbar = findViewById(R.id.dept_information_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(departmentName);

        //recognize
        departmentText = (TextView)findViewById(R.id.departmentText);
        departmentImage = (ImageView) findViewById(R.id.departmentImage);

        getData();

//for checking
        getJsonData();

    }

    private void getData() {   // button e declare korte hoy


        String url = Config.DATA_URL+departmentName;   //    url code for inserting code
        Log.e("result", "url: "+url );
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {      //
                    @Override
                    public void onResponse(String response) {
                        Log.e("result", "response: "+response );
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getApplicationContext(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });



        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response){
//        DepartmentModel aDeptModel = new DepartmentModel() ;
        String title="";
        String detail="";
        String image = "";
        try {

            //=============     data anar jonno    ==================================
            JSONObject jsonObject = new JSONObject(response);
            Log.e("result", "jsonObject: "+jsonObject );

//            JSONObject object = jsonObject.getJSONObject("error");
//            Log.e("result", "object: "+object );


            JSONArray resultJsonArray = jsonObject.getJSONArray("result");
//            Log.e("result", "resultJsonArray: "+resultJsonArray );
//            // JSONArray result = jsonObject.getJSONArray("result");
//
//            for(int i=0;i<resultJsonArray.length();i++) {
//                JSONObject studentData = resultJsonArray.getJSONObject(i);
//                Log.e("result", "studentData: "+studentData );
//
//
//                DepartmentModel aDeptModel = new DepartmentModel() ;
////TODO:: data setup in fields
//                Field[] fields =  aDeptModel.getAllFields() ;
//                for(int j=0; j<fields.length; j++){
//                    String fieldName = fields[j].getName() ;
//                    Log.e("result", "fieldName: "+fieldName );
//                    String fieldValueInJson = studentData.has(fieldName)? studentData.getString(fieldName) : "" ;
//                    Log.e("result", "fieldValueInJson: "+fieldValueInJson );
//                    fields[j].set(aDeptModel, fieldValueInJson);
//                }
////TODO::   hashmap list data setup
//                if(departmentList.containsKey(aDeptModel.getDepartment()) && departmentList.get(aDeptModel.getDepartment()) != null ){
//                   departmentList.get(aDeptModel.getDepartment()).add(aDeptModel) ;
//
//                } else{
//                    ArrayList<DepartmentModel>  = new ArrayList<>() ;
//                    studentList.add(aDeptModel) ;
//                   departmentList.put(aDeptModel.getDepartment(), studentList ) ;
//
//                    keyofMyList.add(aDeptModel.getDepartment());
//
//                }
//
//            }

            JSONObject collegeData = resultJsonArray.getJSONObject(0);
            Log.e("result", "collegeData: "+collegeData );

            //=============     data anar jonno   ===================================

            title = collegeData.getString(Config.TITLE);
            detail = collegeData.getString(Config.DETAIL);
            image = collegeData.getString(Config.IMAGE) ;
            Log.e("result", "image: "+image );

        } catch (JSONException  e) {
            e.printStackTrace();
            Log.e("result", "error: "+e.toString() );

        }

        setTitle(title);
        departmentText.setText(detail);
        //loading the image
        Glide.with(getApplicationContext())
                .load(image)
                .into(departmentImage);
    }

    public void getJsonData(){
        String url = Config.DATA_URL_HASH;
//        Log.e("resultJS", "url: "+url );
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {      //
                    @Override
                    public void onResponse(String response) {
//                        Log.e("resultJS", "responseUrl: "+response );
                        retriveAllData(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }

    private void retriveAllData(String response){

        try {

            JSONObject jsonObject = new JSONObject(response);
//            Log.e("resultJS", "response: "+response );
            JSONArray resultJsonArray = jsonObject.getJSONArray("result");
            Log.e("resultJS", "resultJsonArray: "+resultJsonArray );

            for(int i=0;i<resultJsonArray.length();i++) {
                JSONObject studentData = resultJsonArray.getJSONObject(i);

                DepartmentModel aDeptModel = new DepartmentModel() ;
//TODO:: data setup in fields
                Field[] fields =  aDeptModel.getAllFields() ;
                for(int j=0; j<fields.length; j++){
                    String fieldName = fields[j].getName() ;
                    Log.e("resultJS", "fieldName: "+fieldName );
                    String fieldValueInJson = studentData.has(fieldName)? studentData.getString(fieldName) : "" ;
                    Log.e("resultJS", "fieldValueInJson: "+fieldValueInJson );
                    fields[j].set(aDeptModel, fieldValueInJson);
                }
                Log.e("resultJS", "fields: "+fields.toString() );

//TODO::   hashmap list data setup
                    if(departmentList.containsKey(aDeptModel.getFacultyName()) && departmentList.get(aDeptModel.getFacultyName()) != null ){
                        departmentList.get(aDeptModel.getFacultyName()).add(aDeptModel) ;
                    } else{
                        ArrayList<DepartmentModel> facultyList = new ArrayList<>() ;
                        facultyList.add(aDeptModel) ;
                        departmentList.put(aDeptModel.getFacultyName(), facultyList ) ;
                    }
            }
            Log.e("resultJS", "departmentList: "+departmentList.size());
            Log.e("resultJS", "departmentList Enginner: "+departmentList.get("Engineer").toString() );

        } catch (JSONException | IllegalAccessException e) {
            e.printStackTrace();
            Log.e("resultJS", "error: "+e.toString() );
        }
    }

}
