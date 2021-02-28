package com.sd.saruj.cuhelpguide.controller.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sd.saruj.cuhelpguide.controller.Adapter.NoticeListAdapter;
import com.sd.saruj.cuhelpguide.model.FacultyBuilderClass;
import com.sd.saruj.cuhelpguide.controller.Constant.Config;
import com.sd.saruj.cuhelpguide.controller.Interfaces.NoticeClickInterfaces;
import com.sd.saruj.cuhelpguide.model.FacultyBuilderModel;
import com.sd.saruj.cuhelpguide.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NoticeListActivity extends AppCompatActivity {

    private RecyclerView mNoticeRecycler;
    private Toolbar mNoticeToolbar;

    public static List<FacultyBuilderModel> mNoticeList;
    private NoticeListAdapter mNoticeAdapter;
    NoticeClickInterfaces mItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_list);

        mNoticeToolbar = findViewById(R.id.notice_list_toolbar);
        setSupportActionBar(mNoticeToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle("Admission Notice List");

        mNoticeRecycler = findViewById(R.id.recycler_notice_list) ;
        mNoticeRecycler.setHasFixedSize(true);
        mNoticeRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mNoticeList = new ArrayList<>();


        mItemClickListener = new NoticeClickInterfaces() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(NoticeListActivity.this, NoticeViewActivity.class);
                intent.putExtra("url", mNoticeList.get(position).getType());
                startActivity(intent);
            }
        };

        loadProducts();


    }

    private void loadProducts() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Config.CONSTANT_TABLE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Log.e("TAG", "response:  "+ response ) ;
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray array = jsonObject.getJSONArray("notice_list");

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

                                mNoticeList.add(new FacultyBuilderClass()
                                        .setId(product.getInt("notice_id"))
                                        .setName(product.getString("notice_name"))
                                        .setUrl(product.getString("notice_url"))
                                        .build());
//
                            }

                            mNoticeAdapter = new NoticeListAdapter(mNoticeList, getApplicationContext(), mItemClickListener);
                            mNoticeRecycler.setAdapter(mNoticeAdapter);
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
}
