package com.sd.saruj.cuhelpguide.DepartmentInformation;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sd.saruj.cuhelpguide.Constant.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class DepartmentInformationClass {

//   public static String socialeconomic = "Social Science economic \n  gdhsag gfggasdfgadsfadsasdffashdfh fdasgadffdsha hfdsagdasfgafdgfdadfsgfasddsfahjkgsdfgafdggfad";
//    public static String socialPolitical = "Social Science socialPolitical \n  gdhsag gfggasdfgadsfadsasdffashdfh fdasgadffdsha hfdsagdasfgafdgfdadfsgfasddsfahjkgsdfgafdggfad";
//    public static String socialeSociology = "Social Science socialeSociology \n  gdhsag gfggasdfgadsfadsasdffashdfh fdasgadffdsha hfdsagdasfgafdgfdadfsgfasddsfahjkgsdfgafdggfad";
//    public static String socialeAdministration = "Social Science socialeAdministration \n  gdhsag gfggasdfgadsfadsasdffashdfh fdasgadffdsha hfdsagdasfgafdgfdadfsgfasddsfahjkgsdfgafdggfad";
//    public static String socialeJournalism = "Social Science socialeJournalism \n  gdhsag gfggasdfgadsfadsasdffashdfh fdasgadffdsha hfdsagdasfgafdgfdadfsgfasddsfahjkgsdfgafdggfad";
//    public static String socialCriminology = "Social Science socialCriminology \n  gdhsag gfggasdfgadsfadsasdffashdfh fdasgadffdsha hfdsagdasfgafdgfdadfsgfasddsfahjkgsdfgafdggfad";

//
//
//
//
//    private void getJsonData(){
//        String url = Config.DATA_URL;
//        StringRequest stringRequest = new StringRequest(url,
//                new Response.Listener<String>() {      //
//                    @Override
//                    public void onResponse(String response) {
//                        retriveAllData(response);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getApplicationContext(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
//                    }
//                });
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//    }
//
//    private void retriveAllData(String response){
//        try {
//
//            JSONObject jsonObject = new JSONObject(response);
//            JSONArray resultJsonArray = jsonObject.getJSONArray("result");
//
//            for(int i=0;i<resultJsonArray.length();i++) {
//                JSONObject studentData = resultJsonArray.getJSONObject(i);
//
//                DepartmentModel aDeptModel = new DepartmentModel() ;
////TODO:: data setup in fields
//                Field[] fields =  aDeptModel.getAllFields() ;
//                for(int j=0; j<fields.length; j++){
//                    String fieldName = fields[j].getName() ;
//                    String fieldValueInJson = studentData.has(fieldName)? studentData.getString(fieldName) : "" ;
//                    fields[j].set(aDeptModel, fieldValueInJson);
//                }
//
////TODO::   hashmap list data setup
//                if(departmentList.containsKey(aDeptModel.getFacultyName()) && departmentList.get(aDeptModel.getFacultyName()) != null ){
//                    departmentList.get(aDeptModel.getFacultyName()).add(aDeptModel) ;
//                } else{
//                    ArrayList<DepartmentModel> facultyList = new ArrayList<>() ;
//                    facultyList.add(aDeptModel) ;
//                    departmentList.put(aDeptModel.getFacultyName(), facultyList ) ;
//                }
//            }
//            Log.e("resultJson", "departmentList: "+departmentList.get("Engineer").toString() );
//
//        } catch (JSONException | IllegalAccessException e) {
//            e.printStackTrace();
//            Log.e("result", "error: "+e.toString() );
//        }
//    }
//
//
//
//

}
