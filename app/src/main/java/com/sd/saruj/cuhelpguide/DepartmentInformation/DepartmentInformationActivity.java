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


            JSONArray resultJsonArray = jsonObject.getJSONArray("result");

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





}
