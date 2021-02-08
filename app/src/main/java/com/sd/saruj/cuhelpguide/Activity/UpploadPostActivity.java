package com.sd.saruj.cuhelpguide.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sd.saruj.cuhelpguide.Constant.Config;
import com.sd.saruj.cuhelpguide.R;

import java.util.HashMap;
import java.util.Map;

public class UpploadPostActivity extends AppCompatActivity {

    private EditText titleEditText, editText;
    private Spinner spin1, spin2;
    private Button uploadBtn;

    String spin;

    private static String TAG = "MainActivity"; //MainActivity


    String[] allSubName = {
            "All Subject"
    };
    String[] EngName = {
            "Deparetment of CSE",
            "Department of EEE"
    };
    String[] ArtsName = {
            "Department of Bangla",
            "Department of English",
            "Department of History",
            "Department of Philosophy",
            "Department of Islamic History and Culture"
    };
    String[] BioName = {
            "Department of Zoology",
            "Department of Botany",
            "Department of Pharmacy",
            "Biochemistry and Molecular Biology",
            "Department of Microbiology",
            "Department of Soil Science",
            "Genetic Engineering and Biotechnology",
            "Department of Psychology",
            "Geography and Environmental Studies"
    };

    String[] BusinessName = {
            "Department of Accounting",
            "Department of Management",
            "Department of Finance",
            "Department of Marketing",
            "Human Resource Management",
            "Banking and Insurance"
    };
    String[] forestryName = {
            "Deparetment of Forestry",
            "Department of Environmental"
    };
    String[] marineName = {
            "Deparetment of Marine",
            "Department of Fisharies"
    };
    String[] scienceName = {
            "Department of Physics",
            "Department of Chemistry",
            "Department of Mathematics",
            "Department of Statistics",
            "Applied Chemistry and Chemical Engineering"
    };
    String[] socialName = {
            "Deparetment of Economics",
            "Department of Political Science",
            "Department of Sociology",
            "Department of Public Administration",
            "Communication and Journalism",
            "Criminology and Police Science"
    };
    String[] lawName = {
            "Law"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uppload_post);

        titleEditText = findViewById(R.id.titleEditText);
        editText = findViewById(R.id.editText);
        spin1 = findViewById(R.id.spinner1);
        spin2 = findViewById(R.id.spinner2);
        uploadBtn = findViewById(R.id.uploadBtn);



        spin1.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.allFaculty)));
//        spin2.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DepartmentName));



        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              String spin = adapterView.getItemAtPosition(i).toString();
              switch (spin){
                  case "All Subject":
                      spin2.setAdapter(new ArrayAdapter<>(UpploadPostActivity.this, android.R.layout.simple_list_item_1, allSubName));
                      break;
                  case "Science":
                      spin2.setAdapter(new ArrayAdapter<>(UpploadPostActivity.this, android.R.layout.simple_list_item_1, scienceName));
                      break;
                  case "Social Science":
                      spin2.setAdapter(new ArrayAdapter<>(UpploadPostActivity.this, android.R.layout.simple_list_item_1, socialName));
                      break;
                  case "Engineer":
                      spin2.setAdapter(new ArrayAdapter<>(UpploadPostActivity.this, android.R.layout.simple_list_item_1, EngName));
                      break;
                  case "Biology":
                      spin2.setAdapter(new ArrayAdapter<>(UpploadPostActivity.this, android.R.layout.simple_list_item_1, BioName));
                      break;
                  case "Forestry":
                      spin2.setAdapter(new ArrayAdapter<>(UpploadPostActivity.this, android.R.layout.simple_list_item_1, forestryName));
                      break;
                  case "Business":
                      spin2.setAdapter(new ArrayAdapter<>(UpploadPostActivity.this, android.R.layout.simple_list_item_1, BusinessName));
                      break;
                  case "Arts and Humanities":
                      spin2.setAdapter(new ArrayAdapter<>(UpploadPostActivity.this, android.R.layout.simple_list_item_1, ArtsName));
                      break;
                  case "Law":
                      spin2.setAdapter(new ArrayAdapter<>(UpploadPostActivity.this, android.R.layout.simple_list_item_1, lawName));
                      break;

              }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spin = spin2.getSelectedItem().toString();
                uploadPost();
            }
        });


    }

    private void uploadPost() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.INSERT_POST_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.equalsIgnoreCase("true")){
                    titleEditText.setText("");
                    editText.setText("");

                    Toast.makeText(getApplicationContext(), "Post upload Successfully...", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(), "Please check Connection...", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Please check Connection...", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> parameters = new HashMap<String, String>();

                parameters.put("title", titleEditText.getText().toString());
                parameters.put("post", editText.getText().toString());
                parameters.put("subject", spin);
             //   hidepDialog();

                return parameters;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Log.d("TAG", "stringRequest: "+stringRequest ) ;


    }
}
