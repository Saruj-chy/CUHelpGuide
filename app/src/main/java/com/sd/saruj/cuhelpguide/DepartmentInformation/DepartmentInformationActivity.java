package com.sd.saruj.cuhelpguide.DepartmentInformation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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

import static com.sd.saruj.cuhelpguide.R.string.science_chemistry;

public class DepartmentInformationActivity extends AppCompatActivity {
    TextView departmentText;
    ImageView departmentImage;
    String FacultyName, departmentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_information);

        Intent intent = getIntent();
        FacultyName = intent.getExtras().getString("faculty");
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

//        departmentName = "EEE";


    /*    switch (FacultyName){
            case "Arts":
                switch (departmentName){
                    case "bangla":
                        departmentImage.setImageResource(R.drawable.arts);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_economic);
                    case "english":
                        departmentImage.setImageResource(R.drawable.arts);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_political);
                        break;
                    case "History":
                        departmentImage.setImageResource(R.drawable.arts);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_sociology);
                        break;
                    case "Philosopy":
                        departmentImage.setImageResource(R.drawable.arts);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_administration);
                        break;
                    case "IslamicHistory":
                        departmentImage.setImageResource(R.drawable.arts);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_economic);
                        break;
                }
                break;
            case "Social":
                switch (departmentName){
                    case "economic":
                        departmentImage.setImageResource(R.drawable.social);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_economic);
                        break;
                    case "political":
                        departmentImage.setImageResource(R.drawable.social);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_political);
                        break;
                    case "sociology":
                        departmentImage.setImageResource(R.drawable.social);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_sociology);
                        break;
                    case "public":
                        departmentImage.setImageResource(R.drawable.social);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_administration);
                        break;
                    case "journalism":
                        departmentImage.setImageResource(R.drawable.social);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_journalism);
                        break;
                    case "PoliceScience":
                        departmentImage.setImageResource(R.drawable.social);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_criminology);
                        break;
                }
                break;
            case "Biology":
                switch (departmentName)
                {
                    case "zoology":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_zoology);
                        break;
                    case "botany":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_botany);
                        break;
                    case "pharmacy":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_pharmacy);
                        break;
                    case "biochemistry":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_biochemistry);
                        break;
                    case "microbiology":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_microbiology);
                        break;
                    case "soil":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_soil);
                        break;
                    case "genetic":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_genetic);
                        break;
                    case "psychology":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_psychology);
                        break;
                    case "geography":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_geography);
                        break;
                }
                break;

            case "Business":
                switch (departmentName)
                {
                    case "accounting":
                        departmentImage.setImageResource(R.drawable.business);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.business_account);
                        break;
                    case "management":
                        departmentImage.setImageResource(R.drawable.business);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.business_management);
                        break;
                    case "finance":
                        departmentImage.setImageResource(R.drawable.business);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.business_finance);
                        break;
                    case "marketing":
                        departmentImage.setImageResource(R.drawable.business);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.business_marketing);
                        break;
                    case "humanResource":
                        departmentImage.setImageResource(R.drawable.business);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.business_human);
                        break;
                    case "banking":
                        departmentImage.setImageResource(R.drawable.business);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.business_banking);
                        break;

                }
                break;
            case "Engineer":
                switch (departmentName)
                {
                    case "CSE":
                        departmentImage.setImageResource(R.drawable.engineer);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.engineer_cse);
                        break;
                    case "EEE":
                        departmentImage.setImageResource(R.drawable.engineer);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.engineer_eee);
                        break;


                }
                break;

            case "Forestry":
                switch (departmentName)
                {
                    case "forestry":
                        departmentImage.setImageResource(R.drawable.forestry);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.forestry_forestry);
                        break;
                    case "environment":
                        departmentImage.setImageResource(R.drawable.forestry);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.forestry_environmental);
                        break;


                }
                break;

            case "Marine":
                switch (departmentName)
                {
                    case "marine":
                        departmentImage.setImageResource(R.drawable.merine);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.marine_marine);
                        break;
                    case "fisharies":
                        departmentImage.setImageResource(R.drawable.merine);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.marine_fisharies);
                        break;


                }
                break;

            case "Science":
                switch (departmentName)
                {
                    case "physics":
                        departmentImage.setImageResource(R.drawable.science);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.science_physic);
                        break;
                    case "chemistry":
                        departmentImage.setImageResource(R.drawable.science);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(science_chemistry);
                        break;
                    case "mathematics":
                        departmentImage.setImageResource(R.drawable.science);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.science_mathematics);
                        break;
                    case "statistics":
                        departmentImage.setImageResource(R.drawable.science);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.science_statistics);
                        break;
                    case "appliedChemistry":
                        departmentImage.setImageResource(R.drawable.science);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.science_appliedchemistry);
                        break;




                }
                break;
            case "Law":
                setTitle("Law");

        }*/



        getData();

    }

    private void getData() {   // button e declare korte hoy


        String url = Config.DATA_URL+departmentName;   //    url code for inserting code
//        String url = Config.DATA_URL;

        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {      //
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });



        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response){
        String title="";
        String detail="";
        String image = "";
        try {

            //=============     data anar jonno    ==================================
            JSONObject jsonObject = new JSONObject(response);

            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
            // JSONArray result = jsonObject.getJSONArray("result");

            JSONObject collegeData = result.getJSONObject(0);

            //=============     data anar jonno   ===================================

            title = collegeData.getString(Config.TITLE);
            detail = collegeData.getString(Config.DETAIL);
            image = collegeData.getString(Config.IMAGE);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        setTitle(title);
        departmentText.setText(detail);
        //loading the image
        Glide.with(getApplicationContext())
                .load(image)
                .into(departmentImage);
    }

}
